defmodule SakaVaultWeb.Router do
  use SakaVaultWeb, :router

  pipeline :api do
    plug :accepts, ["json"]
  end

  pipeline :auth do
    plug SakaVaultWeb.Guardian.AuthPipeline
  end

  scope "/api", SakaVaultWeb do
    pipe_through :api

    post "/login", AuthController, :login
    post "/register", AuthController, :register

    pipe_through :auth

    get "/account", AccountController, :show
    delete "/account", AccountController, :delete

    resources "/secrets", VaultController, except: [:new, :edit]
  end
end
