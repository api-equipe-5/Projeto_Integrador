defmodule SakaVault.Vault.Secret do
  @moduledoc false

  use SakaVault.Schema

  alias SakaVault.Accounts.User

  schema "secrets" do
    field :name, :binary
    field :notes, :binary
    field :username, :binary
    field :password, :binary

    belongs_to :user, User

    timestamps()
  end

  def changeset(%__MODULE__{} = secret, params) do
    secret
    |> cast(params, [:user_id, :name, :notes, :username, :password])
    |> validate_required([:user_id, :name, :username, :password])
    |> foreign_key_constraint(:user_id)
  end
end
