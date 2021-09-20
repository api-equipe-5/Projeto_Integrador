ExUnit.start()
Ecto.Adapters.SQL.Sandbox.mode(SakaVault.Repo, :manual)

Mox.defmock(SakaVault.MockSecretsAPI, for: SakaVault.SecretsAPIBehaviour)
