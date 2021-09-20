defmodule SakaVault.Vault do
  @moduledoc false

  alias SakaVault.{
    Accounts.User,
    Krypto,
    Repo,
    Vault.Secret
  }

  import Ecto.Query

  def all(%User{} = user) do
    Secret
    |> where([s], s.user_id == ^user.id)
    |> Repo.all()
  end

  def find(id), do: {:ok, Repo.get(Secret, id)}

  def create(%User{id: user_id}, attrs) do
    attrs
    |> atomize_keys()
    |> Map.put(:user_id, user_id)
    |> Secret.changeset()
    |> Krypto.encrypt()
    |> Repo.insert()
  end

  def update(secret, attrs) do
    secret
    |> Secret.changeset(attrs)
    |> Krypto.encrypt()
    |> Repo.update()
  end

  def delete(secret), do: Repo.delete(secret)

  defp atomize_keys(map) do
    map
    |> Enum.map(&atomize/1)
    |> Enum.into(%{})
  end

  # sobelow_skip ["DOS"]
  defp atomize({k, v}) when is_binary(k), do: {String.to_atom(k), v}
  defp atomize({k, v}) when is_atom(k), do: {k, v}
end
