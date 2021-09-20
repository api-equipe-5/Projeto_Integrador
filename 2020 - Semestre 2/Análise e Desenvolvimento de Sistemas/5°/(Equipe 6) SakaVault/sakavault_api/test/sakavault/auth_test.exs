defmodule SakaVault.AuthTest do
  use SakaVault.DataCase

  alias SakaVault.{Accounts, Auth, Guardian, Krypto}

  setup do
    {:ok, user} =
      :user
      |> params_for()
      |> Accounts.create()

    email =
      user
      |> Krypto.decrypt()
      |> Map.get(:email)

    {:ok, user: user, email: email}
  end

  describe "authenticate/1 with user" do
    test "authenticate user", %{user: %{id: user_id} = user} do
      assert {:ok, %{token: token, user: ^user}} = Auth.authenticate(user)

      assert {:ok, %{"sub" => ^user_id}} = Guardian.decode_and_verify(token)
    end
  end

  describe "authenticate/2" do
    test "authenticate user", %{email: email} do
      assert {:ok, %{token: _, user: _}} = Auth.authenticate(email, "password1234")
    end

    test "invalid password", %{email: email} do
      assert {:error, :invalid_password} = Auth.authenticate(email, "invalidpass")
    end

    test "user not found" do
      assert {:error, :not_found} = Auth.authenticate("john@doe.com", "john123")
    end
  end
end
