defmodule SakaVault.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  use Application

  def start(_type, _args) do
    # Replace Application environment with resolved values
    Confex.resolve_env!(:sakavault)

    children = [
      # Start the Ecto repository
      SakaVault.Repo,
      # Start the Telemetry supervisor
      SakaVaultWeb.Telemetry,
      # Start the PubSub system
      {Phoenix.PubSub, name: SakaVault.PubSub},
      # Start the Endpoint (http/https)
      SakaVaultWeb.Endpoint
      # Start a worker by calling: SakaVault.Worker.start_link(arg)
      # {SakaVault.Worker, arg}
    ]

    # See https://hexdocs.pm/elixir/Supervisor.html
    # for other strategies and supported options
    opts = [strategy: :one_for_one, name: SakaVault.Supervisor]
    Supervisor.start_link(children, opts)
  end

  # Tell Phoenix to update the endpoint configuration
  # whenever the application is updated.
  def config_change(changed, _new, removed) do
    SakaVaultWeb.Endpoint.config_change(changed, removed)
    :ok
  end
end
