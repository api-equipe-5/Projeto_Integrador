# This file is responsible for configuring your application
# and its dependencies with the aid of the Mix.Config module.
#
# This configuration file is loaded before any dependency and
# is restricted to this project.

# General application configuration
import Config

config :sakavault,
  namespace: SakaVault,
  ecto_repos: [SakaVault.Repo],
  generators: [binary_id: true]

config :sakavault, SakaVault.Repo,
  start_apps_before_migration: [:ssl, :logger, :ecto, :ecto_sql],
  migration_primary_key: [
    name: :id,
    type: :binary_id,
    autogenerate: false,
    read_after_writes: true,
    default: {:fragment, "uuid_generate_v4()"}
  ]

# Configures the endpoint
config :sakavault, SakaVaultWeb.Endpoint,
  url: [host: "localhost"],
  secret_key_base: "ZMlN3OXqnceW/aGSm6DFqhL+IZABZD5iTW+H502oPzvJcIAA+cci9FH9b7BxJnKO",
  render_errors: [view: SakaVaultWeb.ErrorView, accepts: ~w(json), layout: false],
  pubsub_server: SakaVault.PubSub,
  live_view: [signing_salt: "XoumypTv"]

# Configures Elixir's Logger
config :logger, :console,
  format: "$time $metadata[$level] $message\n",
  metadata: [:request_id]

# Use Jason for JSON parsing in Phoenix
config :phoenix, :json_library, Jason

config :sakavault, SakaVault.Guardian,
  issuer: "sakavault",
  secret_key: {:system, "GUARDIAN_SECRET_KEY"}

config :ex_aws,
  json_codec: Jason,
  region: "sa-east-1",
  access_key_id: [{:system, "AWS_ACCESS_KEY_ID"}, :instance_role],
  secret_access_key: [{:system, "AWS_SECRET_ACCESS_KEY"}, :instance_role]

config :sakavault, :secrets_api, SakaVault.SecretsAPI

# Import environment specific config. This must remain at the bottom
# of this file so it overrides the configuration defined above.
import_config "#{Mix.env()}.exs"
