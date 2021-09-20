defmodule SakaVaultWeb.Guardian.ErrorHandler do
  @moduledoc """
  Behaviour for creating error handlers for Guardian.Plug.ErrorHandler

  By default, Guardian will emit types of:
    * :unauthorized
    * :invalid_token
    * :already_authenticated
    * :no_resource_found
  """

  import Plug.Conn

  @behaviour Guardian.Plug.ErrorHandler

  @impl Guardian.Plug.ErrorHandler
  def auth_error(conn, {type, _}, _opts) do
    body = Jason.encode!(%{errors: %{detail: to_string(type)}})

    conn
    |> put_resp_content_type("application/json")
    |> send_resp(401, body)
  end
end
