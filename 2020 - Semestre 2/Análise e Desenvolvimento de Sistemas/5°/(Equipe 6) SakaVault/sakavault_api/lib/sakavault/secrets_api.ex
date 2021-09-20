defmodule SakaVault.SecretsAPI do
  @moduledoc false

  @behaviour SakaVault.SecretsAPIBehaviour

  alias ExAws.SecretsManager

  def list do
    SecretsManager.list_secrets() |> ExAws.request()
  end

  def fetch(secret_id) do
    secret_id
    |> secret_name()
    |> SecretsManager.get_secret_value()
    |> ExAws.request()
  end

  def create(secret_id, secret_key) do
    opts = %{
      "SecretString" => secret_key,
      "Name" => secret_name(secret_id),
      "ClientRequestToken" => Ecto.UUID.generate()
    }

    opts
    |> SecretsManager.create_secret()
    |> ExAws.request()
  end

  def delete(secret_id) do
    secret_id
    |> secret_name()
    |> SecretsManager.delete_secret()
    |> ExAws.request()
  end

  defp secret_name(secret_id) do
    case System.get_env("MIX_ENV", nil) do
      nil -> "sakavault/#{secret_id}"
      suffix -> "sakavault_#{suffix}/#{secret_id}"
    end
  end
end
