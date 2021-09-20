# frozen_string_literal: true

class CreateDatabase < ActiveRecord::Migration[6.0]
  def change
    create_table :active_storage_blobs do |t|
      t.string   :key,        null: false
      t.string   :filename,   null: false
      t.string   :content_type
      t.text     :metadata
      t.bigint   :byte_size,  null: false
      t.string   :checksum,   null: false
      t.datetime :created_at, null: false

      t.index [:key], unique: true
    end

    create_table :active_storage_attachments do |t|
      t.string     :name,     null: false
      t.references :record,   null: false, polymorphic: true, index: false
      t.references :blob,     null: false

      t.datetime :created_at, null: false

      t.index %i[record_type record_id name blob_id], name: 'index_active_storage_attachments_uniqueness',
                                                      unique: true
      t.foreign_key :active_storage_blobs, column: :blob_id
    end

    create_table :course_categories do |t|
      t.string :name

      t.timestamps
    end

    create_table :courses do |t|
      t.string :name
      t.string :description
      t.string :meet_url
      t.integer :course_duration
      t.references :course_category, null: true, foreign_key: { to_table: :course_categories }

      t.timestamps
    end

    create_table :course_lectures do |t|
      t.string :name
      t.references :course, null: false, foreign_key: true

      t.timestamps
    end

    create_table :user_courses do |t|
      t.references :user, null: false, foreign_key: true
      t.references :course, null: false, foreign_key: true

      t.timestamps
    end
  end
end
