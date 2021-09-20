# frozen_string_literal: true

if defined?(WillPaginate)
  module WillPaginate
    module ActiveRecord
      module RelationMethods
        alias per per_page
        alias num_pages total_pages
      end
    end
  end
end

module ActiveRecord
  class Relation
    alias total_count count
  end
end
