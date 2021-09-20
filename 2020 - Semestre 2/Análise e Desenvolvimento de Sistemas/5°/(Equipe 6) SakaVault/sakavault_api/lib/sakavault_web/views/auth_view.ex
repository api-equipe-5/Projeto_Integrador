defmodule SakaVaultWeb.AuthView do
  use SakaVaultWeb, :view

  alias SakaVaultWeb.AccountView

  def render("auth.json", %{auth: auth}) do
    user = AccountView.render("account.json", %{user: auth.user})

    %{auth | user: user}
  end
end
