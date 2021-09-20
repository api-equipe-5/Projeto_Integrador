defmodule SakaVault.Support.FileHelpers do
  @moduledoc false

  defp support_path, do: File.cwd!() <> "/test/support"

  def load_json(file), do: {:ok, load_json!(file)}

  def load_json!(file) do
    name = support_path() <> "/json/" <> file <> ".json"

    name
    |> File.read!()
    |> Jason.decode!()
  end
end
