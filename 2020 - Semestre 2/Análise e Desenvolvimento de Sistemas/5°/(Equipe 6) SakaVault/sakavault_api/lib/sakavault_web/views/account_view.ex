defmodule SakaVaultWeb.AccountView do
  use SakaVaultWeb, :view

  def render("account.json", %{user_id: user_id}) do
    %{id: user_id}
  end

  def render("account.json", %{user: user}) do
    Map.take(user, [:id, :name, :email])
  end
end
