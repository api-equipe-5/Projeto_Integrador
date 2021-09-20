defmodule SakaVaultWeb.AccountController do
  use SakaVaultWeb, :controller

  action_fallback SakaVaultWeb.FallbackController

  alias SakaVault.{Accounts, Krypto}

  def action(conn, _) do
    user = Guardian.Plug.current_resource(conn)

    apply(
      __MODULE__,
      action_name(conn),
      [conn, conn.params, user]
    )
  end

  def show(conn, _params, user) do
    case user do
      nil -> {:error, :not_found}
      user -> render(conn, "account.json", user: Krypto.decrypt(user))
    end
  end

  def delete(conn, _params, user) do
    {:ok, user} = Accounts.delete(user)

    render(conn, "account.json", user_id: user.id)
  end
end
