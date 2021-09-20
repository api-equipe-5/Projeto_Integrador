import Config

# Configure your database
#
# The MIX_TEST_PARTITION environment variable can be used
# to provide built-in test partitioning in CI environment.
# Run `mix help test` for more information.
config :sakavault, SakaVault.Repo,
  username: {:system, "POSTGRES_USERNAME", "postgres"},
  password: {:system, "POSTGRES_PASSWORD", "postgres"},
  hostname: {:system, "POSTGRES_HOSTNAME", "postgres"},
  database: "sakavault_test",
  ownership_timeout: 999_999,
  pool: Ecto.Adapters.SQL.Sandbox

# We don't run a server during test. If one is required,
# you can enable the server option below.
config :sakavault, SakaVaultWeb.Endpoint,
  http: [port: 4002],
  server: false

# Print only warnings and errors during test
config :logger, level: :warn

config :sakavault, :secrets_api, SakaVault.MockSecretsAPI
