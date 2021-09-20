defmodule SakaVaultWeb.VaultController do
  use SakaVaultWeb, :controller

  action_fallback SakaVaultWeb.FallbackController

  alias SakaVault.{Krypto, Vault}
  alias SakaVault.Vault.Secret

  def action(conn, _) do
    user = Guardian.Plug.current_resource(conn)

    apply(
      __MODULE__,
      action_name(conn),
      [conn, conn.params, user]
    )
  end

  def index(conn, _params, user) do
    secrets =
      user
      |> Vault.all()
      |> Enum.map(&decrypt_secret/1)
      |> Enum.map(fn {_, secret} -> secret end)

    render(conn, "index.json", secrets: secrets)
  end

  def show(conn, params, _user) do
    with {:ok, secret} <- Vault.find(params["id"]),
         {:ok, secret} <- decrypt_secret(secret) do
      render(conn, "show.json", %{secret: secret})
    end
  end

  def create(conn, params, user) do
    with {:ok, %Secret{} = secret} <- Vault.create(user, params),
         {:ok, %Secret{} = secret} <- decrypt_secret(secret) do
      render(conn, "show.json", %{secret: secret})
    end
  end

  def update(conn, params, _user) do
    with {:ok, %Secret{} = secret} <- Vault.find(params["id"]),
         {:ok, %Secret{} = secret} <- Vault.update(secret, params),
         {:ok, %Secret{} = secret} <- decrypt_secret(secret) do
      render(conn, "show.json", %{secret: secret})
    end
  end

  def delete(conn, params, _user) do
    with {:ok, %Secret{} = secret} <- Vault.find(params["id"]),
         {:ok, %Secret{} = secret} <- Vault.delete(secret) do
      render(conn, "delete.json", %{secret: secret})
    end
  end

  defp decrypt_secret(nil), do: {:ok, nil}
  defp decrypt_secret(%Secret{} = secret), do: {:ok, Krypto.decrypt(secret)}
end
