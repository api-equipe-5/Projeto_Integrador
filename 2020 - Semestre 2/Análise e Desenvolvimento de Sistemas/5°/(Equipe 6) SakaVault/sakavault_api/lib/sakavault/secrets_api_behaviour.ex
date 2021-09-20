defmodule SakaVault.SecretsAPIBehaviour do
  @moduledoc false

  @callback list :: list()

  @callback delete(binary()) :: {:ok, any()} | {:error, any()}
  @callback fetch(binary()) :: {:ok, binary()} | {:error, any()}
  @callback create(binary(), binary()) :: {:ok, any()} | {:error, any()}
end
