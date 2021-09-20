defmodule SakaVaultWeb.AuthControllerTest do
  use SakaVaultWeb.ConnCase

  alias SakaVault.{Accounts, Krypto}

  setup %{conn: conn} do
    {:ok, user} =
      :user
      |> params_for()
      |> Accounts.create()

    user_email =
      user
      |> Krypto.decrypt()
      |> Map.get(:email)

    {
      :ok,
      user: user, user_email: user_email, conn: put_req_header(conn, "accept", "application/json")
    }
  end

  describe "POST /login" do
    test "renders user when data is valid", %{
      conn: conn,
      user: %{id: user_id},
      user_email: user_email
    } do
      params = %{email: user_email, password: "password1234"}

      assert response =
               conn
               |> post(Routes.auth_path(conn, :login), params)
               |> json_response(201)

      assert %{
               "token" => _,
               "user" => %{
                 "id" => ^user_id,
                 "email" => ^user_email
               }
             } = response
    end

    test "when user not found", %{conn: conn} do
      params = %{email: "invalidemail", password: "invalidpass"}

      assert %{"errors" => errors} =
               conn
               |> post(Routes.auth_path(conn, :login), params)
               |> json_response(404)

      assert %{"detail" => "Not Found"} = errors
    end

    test "when invalid password not found", %{conn: conn, user_email: user_email} do
      params = %{email: user_email, password: "invalidpass"}

      assert %{"errors" => errors} =
               conn
               |> post(Routes.auth_path(conn, :login), params)
               |> json_response(401)

      assert %{"detail" => "Unauthorized"} = errors
    end
  end

  describe "POST /register" do
    test "renders user when data is valid", %{conn: conn} do
      params = %{name: "John Doe", password: "johndoe123", email: "john@doe.com"}

      assert response =
               conn
               |> post(Routes.auth_path(conn, :register), params)
               |> json_response(201)

      assert %{
               "token" => token,
               "user" => %{
                 "name" => "John Doe",
                 "email" => "john@doe.com"
               }
             } = response
    end

    test "renders errors when data is invalid", %{conn: conn} do
      assert %{"errors" => errors} =
               conn
               |> post(Routes.auth_path(conn, :register), %{name: "John Doe"})
               |> json_response(422)

      assert %{
               "email" => ["can't be blank"],
               "password" => ["can't be blank"]
             } = errors
    end
  end
end
