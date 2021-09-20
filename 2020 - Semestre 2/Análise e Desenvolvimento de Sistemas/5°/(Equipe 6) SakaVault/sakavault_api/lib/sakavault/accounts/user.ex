defmodule SakaVault.Accounts.User do
  @moduledoc false

  use SakaVault.Schema

  alias SakaVault.Krypto

  schema "users" do
    field :name, :binary
    field :email, :binary

    field :email_hash, :binary
    field :password_hash, :binary

    field :password, :binary, virtual: true

    timestamps()
  end

  def changeset(%__MODULE__{} = user, params) do
    user
    |> cast(params, [:name, :email, :password])
    |> validate_required([:name, :email, :password])
    |> add_email_hash()
    |> add_password_hash()
    |> unique_constraint(:email_hash)
  end

  defp add_email_hash(%{changes: %{email: email}} = changeset) do
    put_change(changeset, :email_hash, Krypto.hash_value(email))
  end

  defp add_email_hash(changeset), do: changeset

  defp add_password_hash(%{changes: %{password: password}} = changeset) do
    put_change(changeset, :password_hash, Krypto.password_value(password))
  end

  defp add_password_hash(changeset), do: changeset
end
