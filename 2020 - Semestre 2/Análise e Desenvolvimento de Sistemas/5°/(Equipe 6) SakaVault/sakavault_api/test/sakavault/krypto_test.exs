defmodule SakaVault.KryptoTest do
  use SakaVault.DataCase

  alias SakaVault.Accounts.User
  alias SakaVault.Vault.Secret

  alias SakaVault.{Krypto, Repo}

  @valid_user_attrs %{
    name: "Max",
    email: "max@example.com",
    password: "NoCarbsBeforeMarbs"
  }

  @valid_secret_attrs %{
    name: "mysecret",
    username: "myusername",
    password: "mypassword"
  }

  describe "secret_id" do
    test "always produces the same secret_id for the same user" do
      %{changes: user} = User.changeset(@valid_user_attrs)

      assert Krypto.secret_id(user) == Krypto.secret_id(user)
    end

    test "never produces the same secret_id for different users" do
      %{changes: user1} = User.changeset(%{@valid_user_attrs | password: "nopass123"})
      %{changes: user2} = User.changeset(%{@valid_user_attrs | password: "nopass100"})

      refute Krypto.secret_id(user1) == Krypto.secret_id(user2)
    end
  end

  describe "salt" do
    test "always produces the same salt for the same value" do
      assert Krypto.salt("value") == Krypto.salt("value")
    end

    test "never produces the same salt for different values" do
      refute Krypto.salt("value0") == Krypto.salt("value1")
    end
  end

  describe "secret_key" do
    test "always produces the same secret_key for the same value" do
      assert Krypto.secret_key("value") == Krypto.secret_key("value")
    end

    test "never produces the same secret_key for different values" do
      refute Krypto.secret_key("value0") == Krypto.secret_key("value1")
    end
  end

  describe "encrypt" do
    test "return raw changeset when user is invalid" do
      assert {:error, %Ecto.Changeset{} = user} =
               %{}
               |> User.changeset()
               |> Krypto.encrypt()
               |> Repo.insert()
    end

    test "return raw changeset when secret is invalid" do
      assert {:error, %Ecto.Changeset{} = secret} =
               %{}
               |> Secret.changeset()
               |> Krypto.encrypt()
               |> Repo.insert()
    end

    test "encrypt user changeset with valid attributes" do
      assert {:ok, %User{} = user} =
               @valid_user_attrs
               |> User.changeset()
               |> Krypto.encrypt()
               |> Repo.insert()

      refute user.name == @valid_user_attrs[:name]
      refute user.email == @valid_user_attrs[:email]
    end

    test "encrypt secret changeset with valid attributes" do
      user = insert(:user)

      assert {:ok, %Secret{} = secret} =
               @valid_secret_attrs
               |> Map.merge(%{user_id: user.id})
               |> Secret.changeset()
               |> Krypto.encrypt()
               |> Repo.insert()

      refute secret.name == @valid_secret_attrs[:name]
      refute secret.username == @valid_secret_attrs[:username]
      refute secret.password == @valid_secret_attrs[:password]
    end
  end

  describe "decrypt" do
    test "user from database" do
      assert {:ok, %User{id: user_id}} =
               @valid_user_attrs
               |> User.changeset()
               |> Krypto.encrypt()
               |> Repo.insert()

      user =
        User
        |> Repo.get(user_id)
        |> Krypto.decrypt()

      assert user.name == @valid_user_attrs[:name]
      assert user.email == @valid_user_attrs[:email]
    end

    test "secret from database" do
      user = insert(:user)

      assert {:ok, %Secret{id: secret_id}} =
               @valid_secret_attrs
               |> Map.merge(%{user_id: user.id})
               |> Secret.changeset()
               |> Krypto.encrypt()
               |> Repo.insert()

      secret =
        Secret
        |> Repo.get(secret_id)
        |> Krypto.decrypt()

      assert secret.name == @valid_secret_attrs[:name]
      assert secret.username == @valid_secret_attrs[:username]
      assert secret.password == @valid_secret_attrs[:password]
    end
  end
end
