defmodule SakaVault.Guardian do
  @moduledoc false

  use Guardian, otp_app: :sakavault

  # You can use any value for the subject of your token but
  # it should be useful in retrieving the resource later, see
  # how it being used on `resource_from_claims/1` function.
  # A unique `id` is a good subject, a non-unique email address
  # is a poor subject.
  def subject_for_token(%{id: id}, _claims) when not is_nil(id), do: {:ok, to_string(id)}

  def subject_for_token(_, _), do: {:error, :invalid_resource}

  # Here we'll look up our resource from the claims, the subject can be
  # found in the `"sub"` key. In `above subject_for_token/2` we returned
  # the resource id so here we'll rely on that to look it up.
  def resource_from_claims(%{"sub" => id}), do: SakaVault.Accounts.find(id)

  def resource_from_claims(_claims), do: {:error, :unknown_resource}
end
