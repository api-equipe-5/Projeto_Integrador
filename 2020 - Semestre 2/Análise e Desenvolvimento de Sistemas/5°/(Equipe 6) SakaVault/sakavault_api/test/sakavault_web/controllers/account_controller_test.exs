defmodule SakaVaultWeb.AccountControllerTest do
  use SakaVaultWeb.ConnCase

  alias SakaVault.{Accounts, Krypto}

  setup %{conn: conn} do
    {:ok, user} =
      :user
      |> params_for()
      |> Accounts.create()

    {:ok, user: user, conn: put_req_header(conn, "accept", "application/json")}
  end

  describe "GET /account" do
    test "returns error if user not authenticated", %{conn: conn} do
      assert %{"errors" => errors} =
               conn
               |> get(Routes.account_path(conn, :show))
               |> json_response(401)

      assert %{"detail" => "unauthenticated"} = errors
    end

    test "returns error if invalid token is used", %{conn: conn} do
      assert %{"errors" => errors} =
               conn
               |> put_req_header("authorization", "Bearer invalid_token")
               |> get(Routes.account_path(conn, :show))
               |> json_response(401)

      assert %{"detail" => "invalid_token"} = errors
    end

    test "returns current user", %{conn: conn, user: user} do
      assert response =
               conn
               |> put_authorization(user)
               |> get(Routes.account_path(conn, :show))
               |> json_response(200)

      decrypted_user = Krypto.decrypt(user)

      assert %{
               "id" => decrypted_user.id,
               "name" => decrypted_user.name,
               "email" => decrypted_user.email
             } == response
    end
  end

  describe "DELETE /account" do
    test "returns error if user not authenticated", %{conn: conn} do
      assert %{"errors" => errors} =
               conn
               |> delete(Routes.account_path(conn, :delete))
               |> json_response(401)

      assert %{"detail" => "unauthenticated"} = errors
    end

    test "returns error if invalid token is used", %{conn: conn} do
      assert %{"errors" => errors} =
               conn
               |> put_req_header("authorization", "Bearer invalid_token")
               |> delete(Routes.account_path(conn, :delete))
               |> json_response(401)

      assert %{"detail" => "invalid_token"} = errors
    end

    test "returns delete user id as confirmation", %{conn: conn, user: %{id: user_id} = user} do
      assert response =
               conn
               |> put_authorization(user)
               |> delete(Routes.account_path(conn, :delete))
               |> json_response(200)

      assert %{"id" => ^user_id} = response

      assert %{"errors" => errors} =
               conn
               |> put_authorization(user)
               |> get(Routes.account_path(conn, :show))
               |> json_response(404)

      assert %{"detail" => "Not Found"} = errors
    end
  end
end
