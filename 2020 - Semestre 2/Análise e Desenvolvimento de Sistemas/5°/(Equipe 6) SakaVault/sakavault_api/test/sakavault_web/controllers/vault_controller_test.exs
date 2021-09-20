defmodule SakaVaultWeb.VaultControllerTest do
  use SakaVaultWeb.ConnCase

  alias SakaVault.{Accounts, Vault}
  alias SakaVault.Vault.Secret

  setup %{conn: conn} do
    {:ok, user} =
      :user
      |> params_for()
      |> Accounts.create()

    params = %{name: "website", username: "john@doe.com", password: "johndoe123"}

    {:ok, secret} = Vault.create(user, params)

    {
      :ok,
      user: user,
      params: params,
      secret: secret,
      conn: put_req_header(conn, "accept", "application/json")
    }
  end

  describe "GET /index" do
    test "returns error if user not authenticated", %{conn: conn} do
      assert response =
               conn
               |> get(Routes.vault_path(conn, :index))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "unauthenticated"}} == response
    end

    test "returns error if invalid token is used", %{conn: conn} do
      assert response =
               conn
               |> put_req_header("authorization", "Bearer invalid_token")
               |> get(Routes.vault_path(conn, :index))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "invalid_token"}} == response
    end

    test "returns user' secrets", %{
      conn: conn,
      user: user,
      secret: %{id: secret1_id}
    } do
      {:ok, %{id: secret2_id}} = Vault.create(user, params_for(:secret))

      assert response =
               conn
               |> put_authorization(user)
               |> get(Routes.vault_path(conn, :index))
               |> json_response(200)

      assert %{"data" => [%{"id" => ^secret1_id}, %{"id" => ^secret2_id}]} = response
    end
  end

  describe "GET /show" do
    test "returns error if user not authenticated", %{conn: conn, secret: secret} do
      assert response =
               conn
               |> get(Routes.vault_path(conn, :show, secret))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "unauthenticated"}} == response
    end

    test "returns error if invalid token is used", %{conn: conn, secret: secret} do
      assert response =
               conn
               |> put_req_header("authorization", "Bearer invalid_token")
               |> get(Routes.vault_path(conn, :show, secret))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "invalid_token"}} == response
    end

    test "return invalid secrets", %{conn: conn, user: user} do
      assert response =
               conn
               |> put_authorization(user)
               |> get(Routes.vault_path(conn, :show, %Secret{id: Ecto.UUID.generate()}))
               |> json_response(200)

      assert %{"data" => nil} == response
    end

    test "returns user' secrets", %{conn: conn, user: user, secret: %{id: secret_id} = secret} do
      assert response =
               conn
               |> put_authorization(user)
               |> get(Routes.vault_path(conn, :show, secret))
               |> json_response(200)

      assert %{
               "data" => %{
                 "id" => ^secret_id,
                 "name" => _,
                 "username" => _,
                 "password" => _,
                 "notes" => _,
                 "inserted_at" => _,
                 "updated_at" => _
               }
             } = response
    end
  end

  describe "POST /create" do
    test "returns error if user not authenticated", %{conn: conn, params: params} do
      assert response =
               conn
               |> post(Routes.vault_path(conn, :create, params))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "unauthenticated"}} == response
    end

    test "returns error if invalid token is used", %{conn: conn, params: params} do
      assert response =
               conn
               |> put_req_header("authorization", "Bearer invalid_token")
               |> post(Routes.vault_path(conn, :create, params))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "invalid_token"}} == response
    end

    test "returns secret validation errors", %{conn: conn, user: user} do
      assert response =
               conn
               |> put_authorization(user)
               |> post(Routes.vault_path(conn, :create, %{name: "website"}))
               |> json_response(422)

      assert %{
               "errors" => %{
                 "username" => ["can't be blank"],
                 "password" => ["can't be blank"]
               }
             } == response
    end

    test "returns created secret", %{conn: conn, user: user, params: params} do
      assert response =
               conn
               |> put_authorization(user)
               |> post(Routes.vault_path(conn, :create, params))
               |> json_response(200)

      assert %{
               "data" => %{
                 "name" => "website",
                 "username" => "john@doe.com",
                 "password" => "johndoe123",
                 "notes" => nil
               }
             } = response
    end
  end

  describe "PATCH /update" do
    test "returns error if user not authenticated", %{conn: conn, secret: secret} do
      assert response =
               conn
               |> patch(Routes.vault_path(conn, :update, secret))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "unauthenticated"}} == response
    end

    test "returns error if invalid token is used", %{conn: conn, secret: secret} do
      assert response =
               conn
               |> put_req_header("authorization", "Bearer invalid_token")
               |> patch(Routes.vault_path(conn, :update, secret))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "invalid_token"}} == response
    end

    test "returns secret validation errors", %{conn: conn, user: user, secret: secret} do
      assert response =
               conn
               |> put_authorization(user)
               |> patch(Routes.vault_path(conn, :update, secret, %{name: ""}))
               |> json_response(422)

      assert %{"errors" => %{"name" => ["can't be blank"]}} == response
    end

    test "returns updated secret", %{conn: conn, user: user, secret: %{id: secret_id} = secret} do
      assert response =
               conn
               |> put_authorization(user)
               |> patch(Routes.vault_path(conn, :update, secret, %{name: "anotherWebsite"}))
               |> json_response(200)

      assert %{
               "data" => %{
                 "id" => ^secret_id,
                 "name" => "anotherWebsite"
               }
             } = response
    end
  end

  describe "DELETE /delete" do
    test "returns error if user not authenticated", %{conn: conn, secret: secret} do
      assert response =
               conn
               |> delete(Routes.vault_path(conn, :delete, secret))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "unauthenticated"}} == response
    end

    test "returns error if invalid token is used", %{conn: conn, secret: secret} do
      assert response =
               conn
               |> put_req_header("authorization", "Bearer invalid_token")
               |> delete(Routes.vault_path(conn, :delete, secret))
               |> json_response(401)

      assert %{"errors" => %{"detail" => "invalid_token"}} == response
    end

    test "returns deleted secret id", %{conn: conn, user: user, secret: secret} do
      assert response =
               conn
               |> put_authorization(user)
               |> delete(Routes.vault_path(conn, :delete, secret))
               |> json_response(200)

      assert %{"data" => %{"deleted" => [secret.id]}} == response
    end
  end
end
