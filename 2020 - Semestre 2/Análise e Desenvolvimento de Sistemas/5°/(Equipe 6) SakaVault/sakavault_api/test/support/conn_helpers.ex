defmodule SakaVault.Support.ConnHelpers do
  @moduledoc false

  alias SakaVault.Accounts.User

  def put_authorization(conn, user) do
    conn
    |> conn_put_req_header("authorization", user)
    |> conn_put_req_header("content-type", "application/json")
  end

  def conn_put_req_header(conn, "authorization" = key, token) when is_bitstring(token) do
    Plug.Conn.put_req_header(conn, key, "Bearer " <> token)
  end

  def conn_put_req_header(conn, "authorization" = key, %User{} = user) do
    token = generate_auth_token(user)

    conn_put_req_header(conn, key, token)
  end

  def conn_put_req_header(conn, key, value) do
    Plug.Conn.put_req_header(conn, key, value)
  end

  def generate_auth_token(user, claims \\ %{}, opts \\ []) do
    case SakaVault.Guardian.encode_and_sign(user, claims, opts) do
      {:ok, token, _claims} -> token
      _ -> nil
    end
  end
end
