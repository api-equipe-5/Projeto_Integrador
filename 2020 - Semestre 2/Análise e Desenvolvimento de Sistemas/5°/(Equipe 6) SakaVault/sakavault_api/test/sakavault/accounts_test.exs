defmodule SakaVault.AccountsTest do
  use SakaVault.DataCase

  alias SakaVault.Accounts
  alias SakaVault.Accounts.User

  setup do
    {:ok, user: insert(:user)}
  end

  describe "find/1" do
    test "with valid id", %{user: user} do
      assert {:ok, %User{} = user} = Accounts.find(user.id)
    end

    test "with invalid id" do
      assert {:ok, nil} = Accounts.find(Ecto.UUID.generate())
    end
  end

  describe "find_by_email/1" do
    test "with valid email", %{user: user} do
      assert {:ok, %User{} = user} = Accounts.find_by_email(user.email)
    end

    test "with invalid email" do
      assert {:ok, nil} = Accounts.find_by_email("invalid@user.com")
    end
  end

  describe "create/1" do
    test "with valid data creates a user" do
      attrs = %{
        name: "John Doe",
        email: "john@doe.com",
        password: "johndoe123"
      }

      assert {:ok, %User{} = user} = Accounts.create(attrs)

      refute user.name == "John Doe"
      refute user.email == "john@doe.com"
    end

    test "invalid data returns error changeset" do
      assert {:error, %Ecto.Changeset{}} = Accounts.create(%{name: "John Doe"})
    end
  end

  describe "delete/1" do
    test "user", %{user: user} do
      assert {:ok, user} = Accounts.delete(user)
      assert {:ok, nil} = Accounts.find(user.id)
    end
  end
end
