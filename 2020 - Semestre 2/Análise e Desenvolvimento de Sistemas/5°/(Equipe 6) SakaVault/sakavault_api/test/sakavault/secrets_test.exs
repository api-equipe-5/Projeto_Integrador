defmodule SakaVault.SecretsTest do
  use SakaVault.DataCase

  alias SakaVault.MockSecretsAPI
  alias SakaVault.Secrets

  describe "create" do
    test "create a secret" do
      expect(MockSecretsAPI, :create, fn _, _ -> load_json("create_secret") end)

      assert {:ok, %{"ARN" => _, "Name" => _, "VersionId" => _}} =
               Secrets.create("secret_id", "secret_key")
    end
  end

  describe "fetch" do
    test "fetch secret" do
      expect(MockSecretsAPI, :fetch, fn _ -> load_json("fetch_secret") end)

      assert {:ok, _} = Secrets.fetch("secret_id")
    end

    test "deleted secret" do
      expect(MockSecretsAPI, :fetch, fn _ -> {:error, {:http_error, 400, "xpto"}} end)

      assert {:error, :not_found} = Secrets.fetch("secret_id")
    end

    test "another error" do
      expect(MockSecretsAPI, :fetch, fn _ -> {:error, {:http_error, 404, "original error"}} end)

      assert {:error, {:http_error, 404, "original error"}} = Secrets.fetch("secret_id")
    end
  end

  describe "delete" do
    test "delete secret" do
      expect(MockSecretsAPI, :delete, fn _ -> load_json("delete_secret") end)

      assert {:ok, _} = Secrets.delete("secret_id")
    end
  end

  describe "delete_all" do
    test "delete all secrets" do
      expect(MockSecretsAPI, :list, fn -> load_json("list_secrets") end)
      expect(MockSecretsAPI, :delete, fn _ -> load_json("delete_secret") end)

      assert :ok = Secrets.delete_all()
    end
  end
end
