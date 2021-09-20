defmodule SakaVault.Vault.SecretTest do
  use SakaVault.DataCase

  alias SakaVault.Vault.Secret

  @valid_attrs %{
    name: "JohnWebsite",
    username: "johndoe",
    password: "johnpass123"
  }

  setup do
    %{
      user: insert(:user),
      secret: insert(:secret)
    }
  end

  describe "changeset validations" do
    test "with valid attributes", %{user: user} do
      assert %{valid?: true} =
               @valid_attrs
               |> Map.merge(%{user_id: user.id})
               |> Secret.changeset()
    end

    test "with valid attributes and invalid user" do
      assert {:error, %{valid?: false}} =
               @valid_attrs
               |> Map.merge(%{user_id: Ecto.UUID.generate()})
               |> Secret.changeset()
               |> Repo.insert()
    end

    test "with invalid attributes", %{user: user} do
      assert %{valid?: false} = Secret.changeset(%{user_id: user.id})
    end
  end

  describe "create" do
    test "with valid attributes", %{user: user} do
      assert {:ok, %Secret{}} =
               @valid_attrs
               |> Map.merge(%{user_id: user.id})
               |> Secret.changeset()
               |> Repo.insert()
    end

    test "with invalid attributes", %{user: user} do
      assert {:error, %{valid?: false}} =
               %{user_id: user.id}
               |> Secret.changeset()
               |> Repo.insert()
    end
  end

  describe "update" do
    test "with valid attributes", %{secret: secret} do
      assert {:ok, secret} =
               secret
               |> Secret.changeset(%{name: "JohnDoeBook"})
               |> Repo.update()

      assert secret.name == "JohnDoeBook"
    end

    test "with invalid attributes", %{secret: secret} do
      assert {:error, %{valid?: false}} =
               secret
               |> Secret.changeset(%{name: ""})
               |> Repo.update()
    end
  end
end
