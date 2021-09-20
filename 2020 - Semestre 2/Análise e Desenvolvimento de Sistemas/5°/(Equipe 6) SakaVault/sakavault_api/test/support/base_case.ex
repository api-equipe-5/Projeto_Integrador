defmodule SakaVault.BaseCase do
  @moduledoc false

  defmacro __using__(opts) do
    opts = Keyword.put_new(opts, :async, true)

    quote do
      use ExUnit.Case, unquote(opts)

      alias SakaVault.Repo

      alias Ecto.{
        Adapters.SQL.Sandbox,
        Changeset
      }

      import Mox
      import SakaVault.Support.Factories
      import SakaVault.Support.FileHelpers

      setup :verify_on_exit!
      setup :stub_secrets_api!

      defp stub_secrets_api!(context \\ %{}) do
        SakaVault.MockSecretsAPI
        |> Mox.stub(:fetch, fn _ -> load_json("fetch_secret") end)
        |> Mox.stub(:delete, fn _ -> load_json("delete_secret") end)
        |> Mox.stub(:create, fn _, _ -> load_json("create_secret") end)

        context
      end

      setup tags do
        pid = Sandbox.start_owner!(SakaVault.Repo, shared: not tags[:async])
        on_exit(fn -> Sandbox.stop_owner(pid) end)
        :ok
      end
    end
  end
end
