defmodule SakaVault.Repo do
  use Ecto.Repo,
    otp_app: :sakavault,
    adapter: Ecto.Adapters.Postgres

  @doc """
  Dynamically loads the repository configuration from the environment variables.
  """
  def init(_, config) do
    url = System.get_env("DATABASE_URL")
    config = if url, do: [url: url] ++ config, else: Confex.Resolver.resolve!(config)

    {:ok, config}
  end
end
