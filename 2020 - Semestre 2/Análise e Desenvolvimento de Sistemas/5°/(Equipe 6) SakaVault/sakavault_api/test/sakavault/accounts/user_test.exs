defmodule SakaVault.Accounts.UserTest do
  use SakaVault.DataCase

  import Ecto.Query

  alias SakaVault.Accounts.User
  alias SakaVault.Krypto

  @valid_attrs %{
    name: "Max",
    email: "max@example.com",
    password: "NoCarbsBeforeMarbs"
  }

  @invalid_attrs %{}

  test "changeset with valid attributes" do
    assert %{valid?: true} = User.changeset(@valid_attrs)
  end

  test "changeset with invalid attributes" do
    assert %{valid?: false} = User.changeset(@invalid_attrs)
  end

  describe "Verify correct working of encryption and hashing" do
    setup do
      user =
        @valid_attrs
        |> User.changeset()
        |> Repo.insert!()

      {:ok, user: user, email: @valid_attrs.email}
    end

    test "inserting a user sets the :email_hash field", %{user: user} do
      assert user.email_hash == Krypto.hash_value(user.email)
    end

    test ":email_hash field is the encrypted hash of the email", %{user: user} do
      loaded_user = Repo.one(User)

      refute loaded_user.email_hash == user.email

      assert loaded_user.email_hash == user.email_hash
      assert loaded_user.email_hash == Krypto.hash_value(user.email)
    end

    test "changeset validates uniqueness of email through email_hash" do
      {:error, %{errors: errors}} = Repo.insert(User.changeset(@valid_attrs))

      assert errors == [
               email_hash:
                 {"has already been taken",
                  [constraint: :unique, constraint_name: "users_email_hash_index"]}
             ]
    end

    test "can decrypt values of encrypted fields when loaded from database", %{user: user} do
      found_user = Repo.one(User)

      assert found_user.name == user.name
      assert found_user.email == user.email
    end

    test "User.get_by_email finds the user by their email address", %{user: user} do
      found_user = Repo.get_by(User, email_hash: Krypto.hash_value(user.email))

      assert found_user.email == user.email
      assert found_user.email_hash == Krypto.hash_value(user.email)
    end

    test "can query on email_hash field because sha256 is deterministic", %{user: user} do
      user_email = Krypto.hash_value(user.email)

      assert %User{} = Repo.get_by(User, email_hash: user_email)
      assert %User{} = Repo.one(from(u in User, where: u.email_hash == ^user_email))
    end
  end
end
