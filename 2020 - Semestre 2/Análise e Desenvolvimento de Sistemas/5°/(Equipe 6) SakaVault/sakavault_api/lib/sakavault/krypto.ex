defmodule SakaVault.Krypto do
  @moduledoc false

  @ignorable_fields ~w(id inserted_at updated_at)
  @ignorable_field_regex ~r/(_id|_hash)$/

  alias Ecto.Changeset

  alias SakaVault.Accounts.User
  alias SakaVault.{Accounts, AES, Secrets}

  def decrypt(%{__struct__: schema} = struct) do
    fields = get_fields(schema)
    secret_key = get_secret_key(schema, struct)

    Enum.reduce(fields, struct, fn field, acc_struct ->
      decrypted_value =
        struct
        |> Map.get(field)
        |> decrypt_value(secret_key)

      %{acc_struct | field => decrypted_value}
    end)
  end

  def encrypt(%{valid?: false} = changeset), do: changeset

  def encrypt(%{data: %{__struct__: schema} = data, changes: changes} = changeset) do
    fields = get_fields(schema)
    secret_key = get_secret_key(schema, changes) || get_secret_key(schema, data)

    Enum.reduce(fields, changeset, fn field, acc_changeset ->
      encrypted_value =
        changeset
        |> Changeset.get_field(field)
        |> encrypt_value(secret_key)

      Changeset.put_change(acc_changeset, field, encrypted_value)
    end)
  end

  defp get_secret_key(User, %{id: user_id}), do: get_secret_key(user_id)
  defp get_secret_key(User, map), do: get_secret_key(map)

  defp get_secret_key(_not_user, %{user_id: user_id}), do: get_secret_key(user_id)
  defp get_secret_key(_not_user, _user_id), do: nil

  defp get_secret_key(user) when is_map(user) do
    {:ok, secret_key} =
      user
      |> secret_id()
      |> Secrets.fetch()

    secret_key
  end

  defp get_secret_key(user_id) when is_binary(user_id) do
    user_id
    |> Accounts.find()
    |> get_secret_key()
  end

  defp get_secret_key({:ok, user}), do: get_secret_key(user)

  defp decrypt_value(nil, _), do: nil
  defp decrypt_value(value, key), do: AES.decrypt(value, key)

  defp encrypt_value(nil, _), do: nil
  defp encrypt_value(value, key), do: AES.encrypt(value, key)

  def hash_value(value), do: salt(value)

  def password_value(password) do
    Argon2.Base.hash_password(password, Argon2.gen_salt(), argon2_type: 2)
  end

  defp get_fields(schema) do
    :fields
    |> schema.__schema__()
    |> Enum.reject(&ignorable_field/1)
  end

  defp ignorable_field(field) when not is_binary(field) do
    field
    |> to_string()
    |> ignorable_field()
  end

  defp ignorable_field(field) do
    field in @ignorable_fields or field =~ @ignorable_field_regex
  end

  def secret_id(%{email_hash: email_hash, password_hash: password_hash}) do
    [email_hash, password_hash]
    |> Enum.join("")
    |> salt()
    |> Base.encode16()
  end

  def salt(value) do
    :crypto.hash(:sha256, value <> secret_key_base())
  end

  def secret_key(key) do
    :sha256
    |> :crypto.hash(key <> secret_key_base())
    |> :base64.encode()
  end

  defp secret_key_base do
    :sakavault
    |> Application.get_env(SakaVaultWeb.Endpoint)
    |> Keyword.get(:secret_key_base)
  end
end
