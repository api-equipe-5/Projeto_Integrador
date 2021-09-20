defmodule SakaVaultWeb.VaultView do
  use SakaVaultWeb, :view

  def render("index.json", %{secrets: secrets}) do
    %{data: render_many(secrets, __MODULE__, "secret.json", as: :secret)}
  end

  def render("show.json", %{secret: secret}) do
    %{data: render_one(secret, __MODULE__, "secret.json", as: :secret)}
  end

  def render("delete.json", %{secret: secret}) do
    %{data: %{deleted: [secret.id]}}
  end

  def render("secret.json", %{secret: secret}) do
    Map.take(secret, [:id, :name, :username, :password, :notes, :inserted_at, :updated_at])
  end
end
