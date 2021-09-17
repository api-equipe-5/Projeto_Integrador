# frozen_string_literal: true

class Ability
  include CanCan::Ability

  def initialize(user)
    user ||= User.new # guest user (not logged in)
    case user.role
    when 'admin'
      can :manage, :all
      can :access, :rails_admin
      can :read, :dashboard
    else
      can :read, :all
    end
  end
end
