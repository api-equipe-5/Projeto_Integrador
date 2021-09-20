defmodule SakaVault.Schema do
  @moduledoc false

  defmacro __using__(_) do
    quote do
      use Ecto.Schema

      alias Ecto.Changeset
      import Ecto.Changeset

      import unquote(__MODULE__)

      @primary_key {:id, :binary_id, autogenerate: true}
      @foreign_key_type :binary_id

      def changeset(%{} = attrs) do
        changeset(struct!(__MODULE__, []), attrs)
      end
    end
  end
end
