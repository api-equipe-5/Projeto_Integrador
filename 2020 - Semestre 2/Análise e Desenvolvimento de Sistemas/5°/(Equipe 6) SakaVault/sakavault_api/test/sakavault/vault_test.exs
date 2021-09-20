defmodule SakaVault.VaultTest do
  use SakaVault.DataCase

  alias SakaVault.Vault
  alias SakaVault.Vault.Secret

  setup do
    user = insert(:user)
    secret = insert(:secret, user: user)

    %{user: user, secret: secret}
  end

  describe "all/1" do
    test "returns all user' secrets", %{user: user, secret: %{id: secret_id}} do
      assert [%Secret{id: ^secret_id}] = Vault.all(user)
    end
  end

  describe "find/1" do
    test "with valid id", %{secret: %{id: secret_id}} do
      assert {:ok, %Secret{id: ^secret_id}} = Vault.find(secret_id)
    end

    test "with invalid id" do
      assert {:ok, nil} = Vault.find(Ecto.UUID.generate())
    end
  end

  describe "delete/1" do
    test "remove secret", %{secret: %{id: secret_id} = secret} do
      assert {:ok, %Secret{id: ^secret_id}} = Vault.delete(secret)
      assert {:ok, nil} = Vault.find(secret_id)
    end
  end

  describe "create/2" do
    test "with valid attrs creates a secret", %{user: %{id: user_id} = user} do
      attrs = %{
        name: "JohnWebsite",
        username: "john@doe.com",
        password: "johndoe123"
      }

      assert {:ok, %Secret{user_id: ^user_id}} = Vault.create(user, attrs)
    end

    test "invalid data returns error changeset", %{user: user} do
      assert {:error, %Ecto.Changeset{}} = Vault.create(user, %{name: "John Doe"})
    end
  end

  describe "update/2" do
    test "with valid attrs updates a secret", %{secret: %{id: secret_id} = secret} do
      attrs = %{
        name: "JohnWebsite",
        username: "john@doe.com",
        password: "johndoe123"
      }

      assert {:ok, %Secret{id: ^secret_id}} = Vault.update(secret, attrs)
    end

    test "invalid data returns error changeset", %{secret: secret} do
      assert {:error, %Ecto.Changeset{}} = Vault.update(secret, %{name: ""})
    end
  end
end
