defmodule SakaVault.GuardianTest do
  use SakaVault.DataCase

  alias SakaVault.Accounts.User
  alias SakaVault.{Accounts, Guardian}

  describe "subject_for_token/2" do
    test "with valid user" do
      id = Ecto.UUID.generate()

      assert {:ok, id} == Guardian.subject_for_token(%User{id: id}, nil)
    end

    test "with invalid user" do
      assert {:error, :invalid_resource} == Guardian.subject_for_token(%User{}, nil)
    end

    test "with invalid resource" do
      assert {:error, :invalid_resource} == Guardian.subject_for_token(%{}, nil)
    end
  end

  describe "resource_from_claims/2" do
    test "with valid claims" do
      {:ok, %{id: user_id} = user} =
        Accounts.create(%{
          name: "John Doe",
          password: "johndoe",
          email: "john@doe.com"
        })

      assert {:ok, %{id: ^user_id}} = Guardian.resource_from_claims(%{"sub" => user.id})
    end

    test "with invalid claims" do
      assert {:error, :unknown_resource} == Guardian.resource_from_claims(%{})
    end
  end
end
