defmodule SakaVaultWeb.ConnCase do
  @moduledoc """
  This module defines the test case to be used by
  tests that require setting up a connection.

  Such tests rely on `Phoenix.ConnTest` and also
  import other functionality to make it easier
  to build common data structures and query the data layer.

  Finally, if the test case interacts with the database,
  we enable the SQL sandbox, so changes done to the database
  are reverted at the end of every test. If you are using
  PostgreSQL, you can even run database tests asynchronously
  by setting `use SakaVaultWeb.ConnCase, async: true`, although
  this option is not recommended for other databases.
  """

  defmacro __using__(opts) do
    quote do
      use SakaVault.BaseCase, unquote(opts)

      # Import conveniences for testing with connections
      import Plug.Conn
      import Phoenix.ConnTest
      import SakaVaultWeb.ConnCase

      import SakaVault.Support.ConnHelpers

      alias SakaVaultWeb.Router.Helpers, as: Routes

      # The default endpoint for testing
      @endpoint SakaVaultWeb.Endpoint

      setup do
        {:ok, conn: Phoenix.ConnTest.build_conn()}
      end
    end
  end
end
