defmodule SakaVault.Secrets do
  @moduledoc false

  def fetch(secret_id) do
    secret_id
    |> secrets_api().fetch()
    |> parse_result()
  end

  def create(secret_id, secret_key) do
    secrets_api().create(secret_id, secret_key)
  end

  def delete(secret_id) do
    secrets_api().delete(secret_id)
  end

  def delete_all do
    {:ok, %{"SecretList" => secrets}} = secrets_api().list()

    secrets
    |> Enum.map(& &1["Name"])
    |> Enum.map(&sanitize_secret_id/1)
    |> Enum.each(&delete/1)
  end

  defp sanitize_secret_id(name) do
    name
    |> String.split("/")
    |> List.last()
  end

  defp parse_result({:ok, %{"SecretString" => secret_key}}), do: {:ok, secret_key}

  defp parse_result({:error, {:http_error, 400, _}}), do: {:error, :not_found}

  defp parse_result(result), do: result

  defp secrets_api, do: Application.get_env(:sakavault, :secrets_api)
end
