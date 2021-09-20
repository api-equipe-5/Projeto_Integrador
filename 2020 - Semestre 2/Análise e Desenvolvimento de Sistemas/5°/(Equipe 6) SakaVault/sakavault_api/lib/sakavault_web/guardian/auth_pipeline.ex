defmodule SakaVaultWeb.Guardian.AuthPipeline do
  @moduledoc false

  use Guardian.Plug.Pipeline,
    otp_app: :sakavault,
    module: SakaVault.Guardian,
    error_handler: SakaVaultWeb.Guardian.ErrorHandler

  # Look for a token in the HTTP Authorization header. (prefixed with "Bearer ")
  #
  plug Guardian.Plug.VerifyHeader

  # return unauthenticated via the error handler if there is no validated token found
  #
  plug Guardian.Plug.EnsureAuthenticated

  # If there is a verified token, load the user using the implementation module
  #
  plug Guardian.Plug.LoadResource
end
