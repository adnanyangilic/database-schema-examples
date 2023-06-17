type ApiKey @db(name: "api_keys") {
  # Type _inet is not supported
  # allowedIps: _inet @db(name: "allowed_ips")
  createdAt: DateTime! @db(name: "created_at")
  createdById: Int @db(name: "created_by_id")
  hidden: Boolean! @default(value: false)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "api_keys_id_seq", initialValue: 1, allocationSize: 1)
  key: String!
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id") @unique
}

type ApplicationRequest @db(name: "application_requests") {
  count: Int! @default(value: 0)
  date: DateTime!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "application_requests_id_seq", initialValue: 1, allocationSize: 1)
  reqType: Int! @db(name: "req_type")
}

type ArInternalMetadatum @db(name: "ar_internal_metadata") {
  createdAt: DateTime! @db(name: "created_at")
  key: ID! @id
  updatedAt: DateTime! @db(name: "updated_at")
  value: String
}

type Badge @db(name: "badges") {
  allowTitle: Boolean! @db(name: "allow_title") @default(value: false)
  autoRevoke: Boolean! @db(name: "auto_revoke") @default(value: true)
  badgeGroupingId: Int! @db(name: "badge_grouping_id") @default(value: 5)
  badgeTypeId: Int! @db(name: "badge_type_id")
  createdAt: DateTime! @db(name: "created_at")
  description: String
  enabled: Boolean! @default(value: true)
  grantCount: Int! @db(name: "grant_count") @default(value: 0)
  icon: String @default(value: "fa-certificate")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "badges_id_seq", initialValue: 100, allocationSize: 1)
  image: String
  listable: Boolean @default(value: true)
  longDescription: String @db(name: "long_description")
  multipleGrant: Boolean! @db(name: "multiple_grant") @default(value: false)
  name: String! @unique
  query: String
  showPosts: Boolean! @db(name: "show_posts") @default(value: false)
  system: Boolean! @default(value: false)
  targetPosts: Boolean @db(name: "target_posts") @default(value: false)
  trigger: Int
  updatedAt: DateTime! @db(name: "updated_at")
}

type BadgeGrouping @db(name: "badge_groupings") {
  createdAt: DateTime! @db(name: "created_at")
  description: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "badge_groupings_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  position: Int!
  updatedAt: DateTime! @db(name: "updated_at")
}

type BadgeType @db(name: "badge_types") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "badge_types_id_seq", initialValue: 1, allocationSize: 1)
  name: String! @unique
  updatedAt: DateTime! @db(name: "updated_at")
}

type CategoriesWebHook @db(name: "categories_web_hooks") {
  categoryId: Int! @db(name: "category_id")
  webHookId: Int! @db(name: "web_hook_id")
}

type Category @db(name: "categories") {
  allowBadges: Boolean! @db(name: "allow_badges") @default(value: true)
  allTopicsWiki: Boolean! @db(name: "all_topics_wiki") @default(value: false)
  autoCloseBasedOnLastPost: Boolean @db(name: "auto_close_based_on_last_post") @default(value: false)
  autoCloseHours: Float @db(name: "auto_close_hours")
  color: String! @default(value: "AB9364")
  containsMessages: Boolean @db(name: "contains_messages")
  createdAt: DateTime! @db(name: "created_at")
  defaultTopPeriod: String @db(name: "default_top_period") @default(value: "all")
  defaultView: String @db(name: "default_view")
  description: String
  emailIn: String @db(name: "email_in") @unique
  emailInAllowStrangers: Boolean @db(name: "email_in_allow_strangers") @default(value: false)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "categories_id_seq", initialValue: 1, allocationSize: 1)
  latestPostId: Int @db(name: "latest_post_id")
  latestTopicId: Int @db(name: "latest_topic_id")
  mailinglistMirror: Boolean! @db(name: "mailinglist_mirror") @default(value: false)
  minimumRequiredTags: Int @db(name: "minimum_required_tags") @default(value: 0)
  name: String! @unique
  nameLower: String! @db(name: "name_lower")
  navigateToFirstPostAfterRead: Boolean! @db(name: "navigate_to_first_post_after_read") @default(value: false)
  numFeaturedTopics: Int @db(name: "num_featured_topics") @default(value: 3)
  parentCategoryId: Int @db(name: "parent_category_id")
  position: Int
  postCount: Int! @db(name: "post_count") @default(value: 0)
  postsDay: Int @db(name: "posts_day") @default(value: 0)
  postsMonth: Int @db(name: "posts_month") @default(value: 0)
  postsWeek: Int @db(name: "posts_week") @default(value: 0)
  postsYear: Int @db(name: "posts_year") @default(value: 0)
  readRestricted: Boolean! @db(name: "read_restricted") @default(value: false)
  showSubcategoryList: Boolean @db(name: "show_subcategory_list") @default(value: false)
  slug: String!
  sortAscending: Boolean @db(name: "sort_ascending")
  sortOrder: String @db(name: "sort_order")
  subcategoryListStyle: String @db(name: "subcategory_list_style") @default(value: "rows_with_featured_topics")
  suppressFromLatest: Boolean @db(name: "suppress_from_latest") @default(value: false)
  textColor: String! @db(name: "text_color") @default(value: "FFFFFF")
  topicCount: Int! @db(name: "topic_count") @default(value: 0)
  topicFeaturedLinkAllowed: Boolean @db(name: "topic_featured_link_allowed") @default(value: true)
  topicId: Int @db(name: "topic_id")
  topicsDay: Int @db(name: "topics_day") @default(value: 0)
  topicsMonth: Int @db(name: "topics_month") @default(value: 0)
  topicsWeek: Int @db(name: "topics_week") @default(value: 0)
  topicsYear: Int @db(name: "topics_year") @default(value: 0)
  topicTemplate: String @db(name: "topic_template")
  updatedAt: DateTime! @db(name: "updated_at")
  uploadedBackgroundId: Int @db(name: "uploaded_background_id")
  uploadedLogoId: Int @db(name: "uploaded_logo_id")
  userId: Int! @db(name: "user_id")
}

type CategoryCustomField @db(name: "category_custom_fields") {
  categoryId: Int! @db(name: "category_id")
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "category_custom_fields_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  updatedAt: DateTime! @db(name: "updated_at")
  value: String
}

type CategoryFeaturedTopic @db(name: "category_featured_topics") {
  categoryId: Int! @db(name: "category_id")
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "category_featured_topics_id_seq", initialValue: 1, allocationSize: 1)
  rank: Int! @default(value: 0)
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type CategoryGroup @db(name: "category_groups") {
  categoryId: Int! @db(name: "category_id")
  createdAt: DateTime! @db(name: "created_at")
  groupId: Int! @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "category_groups_id_seq", initialValue: 1, allocationSize: 1)
  permissionType: Int @db(name: "permission_type") @default(value: 1)
  updatedAt: DateTime! @db(name: "updated_at")
}

type CategorySearchDatum @db(name: "category_search_data") {
  category_id: Int! @id
  locale: String
  rawData: String @db(name: "raw_data")
  # Type tsvector is not supported
  # searchData: tsvector @db(name: "search_data")
  version: Int @default(value: 0)
}

type CategoryTag @db(name: "category_tags") {
  categoryId: Int! @db(name: "category_id")
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "category_tags_id_seq", initialValue: 1, allocationSize: 1)
  tagId: Int! @db(name: "tag_id")
  updatedAt: DateTime @db(name: "updated_at")
}

type CategoryTagGroup @db(name: "category_tag_groups") {
  categoryId: Int! @db(name: "category_id")
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "category_tag_groups_id_seq", initialValue: 1, allocationSize: 1)
  tagGroupId: Int! @db(name: "tag_group_id")
  updatedAt: DateTime @db(name: "updated_at")
}

type CategoryTagStat @db(name: "category_tag_stats") {
  categoryId: Int! @db(name: "category_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "category_tag_stats_id_seq", initialValue: 1, allocationSize: 1)
  tagId: Int! @db(name: "tag_id")
  topicCount: Int! @db(name: "topic_count") @default(value: 0)
}

type CategoryUser @db(name: "category_users") {
  categoryId: Int! @db(name: "category_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "category_users_id_seq", initialValue: 1, allocationSize: 1)
  notificationLevel: Int! @db(name: "notification_level")
  userId: Int! @db(name: "user_id")
}

type ChildTheme @db(name: "child_themes") {
  childThemeId: Int @db(name: "child_theme_id")
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "child_themes_id_seq", initialValue: 1, allocationSize: 1)
  parentThemeId: Int @db(name: "parent_theme_id")
  updatedAt: DateTime @db(name: "updated_at")
}

type ColorScheme @db(name: "color_schemes") {
  baseSchemeId: String @db(name: "base_scheme_id")
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "color_schemes_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  themeId: Int @db(name: "theme_id")
  updatedAt: DateTime! @db(name: "updated_at")
  version: Int! @default(value: 1)
  viaWizard: Boolean! @db(name: "via_wizard") @default(value: false)
}

type ColorSchemeColor @db(name: "color_scheme_colors") {
  colorSchemeId: Int! @db(name: "color_scheme_id")
  createdAt: DateTime! @db(name: "created_at")
  hex: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "color_scheme_colors_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  updatedAt: DateTime! @db(name: "updated_at")
}

type CustomEmoji @db(name: "custom_emojis") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "custom_emojis_id_seq", initialValue: 1, allocationSize: 1)
  name: String! @unique
  updatedAt: DateTime! @db(name: "updated_at")
  uploadId: Int! @db(name: "upload_id")
}

type Developer @db(name: "developers") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "developers_id_seq", initialValue: 1, allocationSize: 1)
  userId: Int! @db(name: "user_id")
}

type DirectoryItem @db(name: "directory_items") {
  createdAt: DateTime @db(name: "created_at")
  daysVisited: Int! @db(name: "days_visited") @default(value: 0)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "directory_items_id_seq", initialValue: 1, allocationSize: 1)
  likesGiven: Int! @db(name: "likes_given")
  likesReceived: Int! @db(name: "likes_received")
  periodType: Int! @db(name: "period_type")
  postCount: Int! @db(name: "post_count")
  postsRead: Int! @db(name: "posts_read") @default(value: 0)
  topicCount: Int! @db(name: "topic_count")
  topicsEntered: Int! @db(name: "topics_entered")
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type Draft @db(name: "drafts") {
  createdAt: DateTime! @db(name: "created_at")
  data: String!
  draftKey: String! @db(name: "draft_key")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "drafts_id_seq", initialValue: 1, allocationSize: 1)
  revisions: Int! @default(value: 1)
  sequence: Int! @default(value: 0)
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type DraftSequence @db(name: "draft_sequences") {
  draftKey: String! @db(name: "draft_key")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "draft_sequences_id_seq", initialValue: 1, allocationSize: 1)
  sequence: Int!
  userId: Int! @db(name: "user_id")
}

type EmailChangeRequest @db(name: "email_change_requests") {
  changeState: Int! @db(name: "change_state")
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "email_change_requests_id_seq", initialValue: 1, allocationSize: 1)
  newEmail: String! @db(name: "new_email")
  newEmailTokenId: Int @db(name: "new_email_token_id")
  oldEmail: String! @db(name: "old_email")
  oldEmailTokenId: Int @db(name: "old_email_token_id")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type EmailLog @db(name: "email_logs") {
  bounced: Boolean! @default(value: false)
  bounceKey: UUID @db(name: "bounce_key")
  createdAt: DateTime! @db(name: "created_at")
  emailType: String! @db(name: "email_type")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "email_logs_id_seq", initialValue: 1, allocationSize: 1)
  messageId: String @db(name: "message_id")
  postId: Int @db(name: "post_id")
  toAddress: String! @db(name: "to_address")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id")
}

type EmailToken @db(name: "email_tokens") {
  confirmed: Boolean! @default(value: false)
  createdAt: DateTime! @db(name: "created_at")
  email: String!
  expired: Boolean! @default(value: false)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "email_tokens_id_seq", initialValue: 1, allocationSize: 1)
  token: String! @unique
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type EmbeddableHost @db(name: "embeddable_hosts") {
  categoryId: Int! @db(name: "category_id")
  className: String @db(name: "class_name")
  createdAt: DateTime @db(name: "created_at")
  host: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "embeddable_hosts_id_seq", initialValue: 1, allocationSize: 1)
  pathWhitelist: String @db(name: "path_whitelist")
  updatedAt: DateTime @db(name: "updated_at")
}

type FacebookUserInfo @db(name: "facebook_user_infos") {
  aboutMe: String @db(name: "about_me")
  avatarUrl: String @db(name: "avatar_url")
  createdAt: DateTime! @db(name: "created_at")
  email: String
  facebookUserId: Int! @db(name: "facebook_user_id") @unique
  firstName: String @db(name: "first_name")
  gender: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "facebook_user_infos_id_seq", initialValue: 1, allocationSize: 1)
  lastName: String @db(name: "last_name")
  link: String
  location: String
  name: String
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id") @unique
  username: String
  website: String
}

type GithubUserInfo @db(name: "github_user_infos") {
  createdAt: DateTime! @db(name: "created_at")
  githubUserId: Int! @db(name: "github_user_id") @unique
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "github_user_infos_id_seq", initialValue: 1, allocationSize: 1)
  screenName: String! @db(name: "screen_name")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id") @unique
}

type GivenDailyLike @db(name: "given_daily_likes") {
  givenDate: DateTime! @db(name: "given_date")
  likesGiven: Int! @db(name: "likes_given")
  limitReached: Boolean! @db(name: "limit_reached") @default(value: false)
  userId: Int! @db(name: "user_id")
}

type GoogleUserInfo @db(name: "google_user_infos") {
  createdAt: DateTime! @db(name: "created_at")
  email: String
  firstName: String @db(name: "first_name")
  gender: String
  googleUserId: String! @db(name: "google_user_id") @unique
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "google_user_infos_id_seq", initialValue: 1, allocationSize: 1)
  lastName: String @db(name: "last_name")
  link: String
  name: String
  picture: String
  profileLink: String @db(name: "profile_link")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id") @unique
}

type Group @db(name: "groups") {
  allowMembershipRequests: Boolean! @db(name: "allow_membership_requests") @default(value: false)
  automatic: Boolean! @default(value: false)
  automaticMembershipEmailDomains: String @db(name: "automatic_membership_email_domains")
  automaticMembershipRetroactive: Boolean @db(name: "automatic_membership_retroactive") @default(value: false)
  bioCooked: String @db(name: "bio_cooked")
  bioRaw: String @db(name: "bio_raw")
  createdAt: DateTime! @db(name: "created_at")
  defaultNotificationLevel: Int! @db(name: "default_notification_level") @default(value: 3)
  flairBgColor: String @db(name: "flair_bg_color")
  flairColor: String @db(name: "flair_color")
  flairUrl: String @db(name: "flair_url")
  fullName: String @db(name: "full_name")
  grantTrustLevel: Int @db(name: "grant_trust_level")
  hasMessages: Boolean! @db(name: "has_messages") @default(value: false)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "groups_id_seq", initialValue: 100, allocationSize: 1)
  incomingEmail: String @db(name: "incoming_email") @unique
  membershipRequestTemplate: String @db(name: "membership_request_template")
  mentionableLevel: Int @db(name: "mentionable_level") @default(value: 0)
  messageableLevel: Int @db(name: "messageable_level") @default(value: 0)
  name: String! @unique
  primaryGroup: Boolean! @db(name: "primary_group") @default(value: false)
  publicAdmission: Boolean! @db(name: "public_admission") @default(value: false)
  publicExit: Boolean! @db(name: "public_exit") @default(value: false)
  title: String
  updatedAt: DateTime! @db(name: "updated_at")
  userCount: Int! @db(name: "user_count") @default(value: 0)
  visibilityLevel: Int! @db(name: "visibility_level") @default(value: 0)
}

type GroupArchivedMessage @db(name: "group_archived_messages") {
  createdAt: DateTime @db(name: "created_at")
  groupId: Int! @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "group_archived_messages_id_seq", initialValue: 1, allocationSize: 1)
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime @db(name: "updated_at")
}

type GroupCustomField @db(name: "group_custom_fields") {
  createdAt: DateTime! @db(name: "created_at")
  groupId: Int! @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "group_custom_fields_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  updatedAt: DateTime! @db(name: "updated_at")
  value: String
}

type GroupHistory @db(name: "group_histories") {
  actingUserId: Int! @db(name: "acting_user_id")
  action: Int!
  createdAt: DateTime! @db(name: "created_at")
  groupId: Int! @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "group_histories_id_seq", initialValue: 1, allocationSize: 1)
  newValue: String @db(name: "new_value")
  prevValue: String @db(name: "prev_value")
  subject: String
  targetUserId: Int @db(name: "target_user_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type GroupMention @db(name: "group_mentions") {
  createdAt: DateTime @db(name: "created_at")
  groupId: Int @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "group_mentions_id_seq", initialValue: 1, allocationSize: 1)
  postId: Int @db(name: "post_id")
  updatedAt: DateTime @db(name: "updated_at")
}

type GroupsWebHook @db(name: "groups_web_hooks") {
  groupId: Int! @db(name: "group_id")
  webHookId: Int! @db(name: "web_hook_id")
}

type GroupUser @db(name: "group_users") {
  createdAt: DateTime! @db(name: "created_at")
  groupId: Int! @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "group_users_id_seq", initialValue: 1, allocationSize: 1)
  notificationLevel: Int! @db(name: "notification_level") @default(value: 2)
  owner: Boolean! @default(value: false)
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type IncomingDomain @db(name: "incoming_domains") {
  https: Boolean! @default(value: false)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "incoming_domains_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  port: Int!
}

type IncomingEmail @db(name: "incoming_emails") {
  ccAddresses: String @db(name: "cc_addresses")
  createdAt: DateTime! @db(name: "created_at")
  error: String
  fromAddress: String @db(name: "from_address")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "incoming_emails_id_seq", initialValue: 1, allocationSize: 1)
  isAutoGenerated: Boolean @db(name: "is_auto_generated") @default(value: false)
  isBounce: Boolean! @db(name: "is_bounce") @default(value: false)
  messageId: String @db(name: "message_id")
  postId: Int @db(name: "post_id")
  raw: String
  rejectionMessage: String @db(name: "rejection_message")
  subject: String
  toAddresses: String @db(name: "to_addresses")
  topicId: Int @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id")
}

type IncomingLink @db(name: "incoming_links") {
  createdAt: DateTime! @db(name: "created_at")
  currentUserId: Int @db(name: "current_user_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "incoming_links_id_seq", initialValue: 1, allocationSize: 1)
  incomingRefererId: Int @db(name: "incoming_referer_id")
  # Type inet is not supported
  # ipAddress: inet @db(name: "ip_address")
  postId: Int! @db(name: "post_id")
  userId: Int @db(name: "user_id")
}

type IncomingReferer @db(name: "incoming_referers") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "incoming_referers_id_seq", initialValue: 1, allocationSize: 1)
  incomingDomainId: Int! @db(name: "incoming_domain_id")
  path: String!
}

type InstagramUserInfo @db(name: "instagram_user_infos") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "instagram_user_infos_id_seq", initialValue: 1, allocationSize: 1)
  instagramUserId: Int @db(name: "instagram_user_id")
  screenName: String @db(name: "screen_name")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id")
}

type Invite @db(name: "invites") {
  createdAt: DateTime! @db(name: "created_at")
  customMessage: String @db(name: "custom_message")
  deletedAt: DateTime @db(name: "deleted_at")
  deletedById: Int @db(name: "deleted_by_id")
  email: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "invites_id_seq", initialValue: 1, allocationSize: 1)
  invalidatedAt: DateTime @db(name: "invalidated_at")
  invitedById: Int! @db(name: "invited_by_id")
  inviteKey: String! @db(name: "invite_key") @unique
  moderator: Boolean! @default(value: false)
  redeemedAt: DateTime @db(name: "redeemed_at")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id")
}

type InvitedGroup @db(name: "invited_groups") {
  createdAt: DateTime! @db(name: "created_at")
  groupId: Int @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "invited_groups_id_seq", initialValue: 1, allocationSize: 1)
  inviteId: Int @db(name: "invite_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type JavascriptCach @db(name: "javascript_caches") {
  content: String!
  createdAt: DateTime! @db(name: "created_at")
  digest: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "javascript_caches_id_seq", initialValue: 1, allocationSize: 1)
  themeFieldId: Int! @db(name: "theme_field_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type MessageBus @db(name: "message_bus") {
  context: String
  createdAt: DateTime! @db(name: "created_at")
  data: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "message_bus_id_seq", initialValue: 1, allocationSize: 1)
  name: String
}

type MutedUser @db(name: "muted_users") {
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "muted_users_id_seq", initialValue: 1, allocationSize: 1)
  mutedUserId: Int! @db(name: "muted_user_id")
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type Notification @db(name: "notifications") {
  createdAt: DateTime! @db(name: "created_at")
  data: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "notifications_id_seq", initialValue: 1, allocationSize: 1)
  notificationType: Int! @db(name: "notification_type")
  postActionId: Int @db(name: "post_action_id")
  postNumber: Int @db(name: "post_number")
  read: Boolean! @default(value: false)
  topicId: Int @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type Oauth2UserInfo @db(name: "oauth2_user_infos") {
  createdAt: DateTime! @db(name: "created_at")
  email: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "oauth2_user_infos_id_seq", initialValue: 1, allocationSize: 1)
  name: String
  provider: String!
  uid: String!
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type OnceoffLog @db(name: "onceoff_logs") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "onceoff_logs_id_seq", initialValue: 1, allocationSize: 1)
  jobName: String @db(name: "job_name")
  updatedAt: DateTime! @db(name: "updated_at")
}

type OptimizedImage @db(name: "optimized_images") {
  extension: String!
  filesize: Int
  height: Int!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "optimized_images_id_seq", initialValue: 1, allocationSize: 1)
  sha1: String!
  uploadId: Int! @db(name: "upload_id")
  url: String!
  width: Int!
}

type Permalink @db(name: "permalinks") {
  categoryId: Int @db(name: "category_id")
  createdAt: DateTime @db(name: "created_at")
  externalUrl: String @db(name: "external_url")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "permalinks_id_seq", initialValue: 1, allocationSize: 1)
  postId: Int @db(name: "post_id")
  topicId: Int @db(name: "topic_id")
  updatedAt: DateTime @db(name: "updated_at")
  url: String! @unique
}

type PluginStoreRow @db(name: "plugin_store_rows") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "plugin_store_rows_id_seq", initialValue: 1, allocationSize: 1)
  key: String!
  pluginName: String! @db(name: "plugin_name")
  typeName: String! @db(name: "type_name")
  value: String
}

type Post @db(name: "posts") {
  actionCode: String @db(name: "action_code")
  avgTime: Int @db(name: "avg_time")
  bakedAt: DateTime @db(name: "baked_at")
  bakedVersion: Int @db(name: "baked_version")
  bookmarkCount: Int! @db(name: "bookmark_count") @default(value: 0)
  # The processed HTML that is presented in a topic.
  cooked: String!
  cookMethod: Int! @db(name: "cook_method") @default(value: 1)
  createdAt: DateTime! @db(name: "created_at")
  deletedAt: DateTime @db(name: "deleted_at")
  deletedById: Int @db(name: "deleted_by_id")
  editReason: String @db(name: "edit_reason")
  hidden: Boolean! @default(value: false)
  hiddenAt: DateTime @db(name: "hidden_at")
  hiddenReasonId: Int @db(name: "hidden_reason_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "posts_id_seq", initialValue: 1, allocationSize: 1)
  illegalCount: Int! @db(name: "illegal_count") @default(value: 0)
  imageUrl: String @db(name: "image_url")
  inappropriateCount: Int! @db(name: "inappropriate_count") @default(value: 0)
  incomingLinkCount: Int! @db(name: "incoming_link_count") @default(value: 0)
  lastEditorId: Int @db(name: "last_editor_id")
  lastVersionAt: DateTime! @db(name: "last_version_at")
  likeCount: Int! @db(name: "like_count") @default(value: 0)
  likeScore: Int! @db(name: "like_score") @default(value: 0)
  lockedById: Int @db(name: "locked_by_id")
  notifyModeratorsCount: Int! @db(name: "notify_moderators_count") @default(value: 0)
  notifyUserCount: Int! @db(name: "notify_user_count") @default(value: 0)
  offTopicCount: Int! @db(name: "off_topic_count") @default(value: 0)
  percentRank: Float @db(name: "percent_rank") @default(value: 1.0)
  # The position of this post in the topic. The pair (topic_id, post_number) forms a natural key on the posts table.
  postNumber: Int! @db(name: "post_number")
  postType: Int! @db(name: "post_type") @default(value: 1)
  publicVersion: Int! @db(name: "public_version") @default(value: 1)
  quoteCount: Int! @db(name: "quote_count") @default(value: 0)
  # The raw Markdown that the user entered into the composer.
  raw: String!
  rawEmail: String @db(name: "raw_email")
  reads: Int! @default(value: 0)
  replyCount: Int! @db(name: "reply_count") @default(value: 0)
  # This column is true if the post contains a quote-reply, which causes the in-reply-to indicator to be absent.
  replyQuoted: Boolean! @db(name: "reply_quoted") @default(value: false)
  # If this post is a reply to another, this column is the post_number of the post it's replying to. [FKEY posts.topic_id, posts.post_number]
  replyToPostNumber: Int @db(name: "reply_to_post_number")
  replyToUserId: Int @db(name: "reply_to_user_id")
  score: Float
  selfEdits: Int! @db(name: "self_edits") @default(value: 0)
  sortOrder: Int @db(name: "sort_order")
  spamCount: Int! @db(name: "spam_count") @default(value: 0)
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
  userDeleted: Boolean! @db(name: "user_deleted") @default(value: false)
  userId: Int @db(name: "user_id")
  version: Int! @default(value: 1)
  viaEmail: Boolean! @db(name: "via_email") @default(value: false)
  wiki: Boolean! @default(value: false)
  wordCount: Int @db(name: "word_count")
}

type PostAction @db(name: "post_actions") {
  agreedAt: DateTime @db(name: "agreed_at")
  agreedById: Int @db(name: "agreed_by_id")
  createdAt: DateTime! @db(name: "created_at")
  deferredAt: DateTime @db(name: "deferred_at")
  deferredById: Int @db(name: "deferred_by_id")
  deletedAt: DateTime @db(name: "deleted_at")
  deletedById: Int @db(name: "deleted_by_id")
  disagreedAt: DateTime @db(name: "disagreed_at")
  disagreedById: Int @db(name: "disagreed_by_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "post_actions_id_seq", initialValue: 1, allocationSize: 1)
  postActionTypeId: Int! @db(name: "post_action_type_id")
  postId: Int! @db(name: "post_id")
  relatedPostId: Int @db(name: "related_post_id")
  staffTookAction: Boolean! @db(name: "staff_took_action") @default(value: false)
  targetsTopic: Boolean! @db(name: "targets_topic") @default(value: false)
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type PostActionType @db(name: "post_action_types") {
  createdAt: DateTime! @db(name: "created_at")
  icon: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "post_action_types_id_seq", initialValue: 1, allocationSize: 1)
  isFlag: Boolean! @db(name: "is_flag") @default(value: false)
  nameKey: String! @db(name: "name_key")
  position: Int! @default(value: 0)
  updatedAt: DateTime! @db(name: "updated_at")
}

type PostCustomField @db(name: "post_custom_fields") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "post_custom_fields_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  postId: Int! @db(name: "post_id")
  updatedAt: DateTime! @db(name: "updated_at")
  value: String
}

type PostDetail @db(name: "post_details") {
  createdAt: DateTime! @db(name: "created_at")
  extra: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "post_details_id_seq", initialValue: 1, allocationSize: 1)
  key: String
  postId: Int @db(name: "post_id")
  updatedAt: DateTime! @db(name: "updated_at")
  value: String
}

type PostReply @db(name: "post_replies") {
  createdAt: DateTime! @db(name: "created_at")
  postId: Int @db(name: "post_id")
  replyId: Int @db(name: "reply_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type PostReplyKey @db(name: "post_reply_keys") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "post_reply_keys_id_seq", initialValue: 1, allocationSize: 1)
  postId: Int! @db(name: "post_id")
  replyKey: UUID! @db(name: "reply_key") @unique
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type PostRevision @db(name: "post_revisions") {
  createdAt: DateTime! @db(name: "created_at")
  hidden: Boolean! @default(value: false)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "post_revisions_id_seq", initialValue: 1, allocationSize: 1)
  modifications: String
  number: Int
  postId: Int @db(name: "post_id")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id")
}

type PostSearchDatum @db(name: "post_search_data") {
  locale: String
  post_id: Int! @id
  rawData: String @db(name: "raw_data")
  # Type tsvector is not supported
  # searchData: tsvector @db(name: "search_data")
  version: Int @default(value: 0)
}

type PostStat @db(name: "post_stats") {
  composerOpenDurationMsecs: Int @db(name: "composer_open_duration_msecs")
  createdAt: DateTime @db(name: "created_at")
  draftsSaved: Int @db(name: "drafts_saved")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "post_stats_id_seq", initialValue: 1, allocationSize: 1)
  postId: Int @db(name: "post_id")
  typingDurationMsecs: Int @db(name: "typing_duration_msecs")
  updatedAt: DateTime @db(name: "updated_at")
}

type PostTiming @db(name: "post_timings") {
  msecs: Int!
  postNumber: Int! @db(name: "post_number")
  topicId: Int! @db(name: "topic_id")
  userId: Int! @db(name: "user_id")
}

type PostUpload @db(name: "post_uploads") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "post_uploads_id_seq", initialValue: 1, allocationSize: 1)
  postId: Int! @db(name: "post_id")
  uploadId: Int! @db(name: "upload_id")
}

type PushSubscription @db(name: "push_subscriptions") {
  createdAt: DateTime! @db(name: "created_at")
  data: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "push_subscriptions_id_seq", initialValue: 1, allocationSize: 1)
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type QueuedPost @db(name: "queued_posts") {
  approvedAt: DateTime @db(name: "approved_at")
  approvedById: Int @db(name: "approved_by_id")
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "queued_posts_id_seq", initialValue: 1, allocationSize: 1)
  postOptions: Json! @db(name: "post_options")
  queue: String!
  raw: String!
  rejectedAt: DateTime @db(name: "rejected_at")
  rejectedById: Int @db(name: "rejected_by_id")
  state: Int!
  topicId: Int @db(name: "topic_id")
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type QuotedPost @db(name: "quoted_posts") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "quoted_posts_id_seq", initialValue: 1, allocationSize: 1)
  postId: Int! @db(name: "post_id")
  quotedPostId: Int! @db(name: "quoted_post_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type RemoteTheme @db(name: "remote_themes") {
  aboutUrl: String @db(name: "about_url")
  branch: String
  commitsBehind: Int @db(name: "commits_behind")
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "remote_themes_id_seq", initialValue: 1, allocationSize: 1)
  lastErrorText: String @db(name: "last_error_text")
  licenseUrl: String @db(name: "license_url")
  localVersion: String @db(name: "local_version")
  privateKey: String @db(name: "private_key")
  remoteUpdatedAt: DateTime @db(name: "remote_updated_at")
  remoteUrl: String! @db(name: "remote_url")
  remoteVersion: String @db(name: "remote_version")
  updatedAt: DateTime @db(name: "updated_at")
}

type SchedulerStat @db(name: "scheduler_stats") {
  durationMs: Int @db(name: "duration_ms")
  error: String
  hostname: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "scheduler_stats_id_seq", initialValue: 1, allocationSize: 1)
  liveSlotsFinish: Int @db(name: "live_slots_finish")
  liveSlotsStart: Int @db(name: "live_slots_start")
  name: String!
  pid: Int!
  startedAt: DateTime! @db(name: "started_at")
  success: Boolean
}

type SchemaMigration @db(name: "schema_migrations") {
  version: ID! @id
}

type SchemaMigrationDetail @db(name: "schema_migration_details") {
  createdAt: DateTime! @db(name: "created_at")
  direction: String
  duration: Int
  gitVersion: String @db(name: "git_version")
  hostname: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "schema_migration_details_id_seq", initialValue: 1, allocationSize: 1)
  name: String
  railsVersion: String @db(name: "rails_version")
  version: String!
}

type ScreenedEmail @db(name: "screened_emails") {
  actionType: Int! @db(name: "action_type")
  createdAt: DateTime! @db(name: "created_at")
  email: String! @unique
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "screened_emails_id_seq", initialValue: 1, allocationSize: 1)
  # Type inet is not supported
  # ipAddress: inet @db(name: "ip_address")
  lastMatchAt: DateTime @db(name: "last_match_at")
  matchCount: Int! @db(name: "match_count") @default(value: 0)
  updatedAt: DateTime! @db(name: "updated_at")
}

type ScreenedIpAddress @db(name: "screened_ip_addresses") {
  actionType: Int! @db(name: "action_type")
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "screened_ip_addresses_id_seq", initialValue: 1, allocationSize: 1)
  # Type inet is not supported
  # ipAddress: inet! @db(name: "ip_address") @unique
  lastMatchAt: DateTime @db(name: "last_match_at")
  matchCount: Int! @db(name: "match_count") @default(value: 0)
  updatedAt: DateTime! @db(name: "updated_at")
}

type ScreenedUrl @db(name: "screened_urls") {
  actionType: Int! @db(name: "action_type")
  createdAt: DateTime! @db(name: "created_at")
  domain: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "screened_urls_id_seq", initialValue: 1, allocationSize: 1)
  # Type inet is not supported
  # ipAddress: inet @db(name: "ip_address")
  lastMatchAt: DateTime @db(name: "last_match_at")
  matchCount: Int! @db(name: "match_count") @default(value: 0)
  updatedAt: DateTime! @db(name: "updated_at")
  url: String! @unique
}

type SearchLog @db(name: "search_logs") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "search_logs_id_seq", initialValue: 1, allocationSize: 1)
  # Type inet is not supported
  # ipAddress: inet @db(name: "ip_address")
  searchResultId: Int @db(name: "search_result_id")
  searchResultType: Int @db(name: "search_result_type")
  searchType: Int! @db(name: "search_type")
  term: String!
  userId: Int @db(name: "user_id")
}

type SharedDraft @db(name: "shared_drafts") {
  categoryId: Int! @db(name: "category_id")
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "shared_drafts_id_seq", initialValue: 1, allocationSize: 1)
  topicId: Int! @db(name: "topic_id") @unique
  updatedAt: DateTime! @db(name: "updated_at")
}

type SingleSignOnRecord @db(name: "single_sign_on_records") {
  createdAt: DateTime! @db(name: "created_at")
  externalAvatarUrl: String @db(name: "external_avatar_url")
  externalCardBackgroundUrl: String @db(name: "external_card_background_url")
  externalEmail: String @db(name: "external_email")
  externalId: String! @db(name: "external_id") @unique
  externalName: String @db(name: "external_name")
  externalProfileBackgroundUrl: String @db(name: "external_profile_background_url")
  externalUsername: String @db(name: "external_username")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "single_sign_on_records_id_seq", initialValue: 1, allocationSize: 1)
  lastPayload: String! @db(name: "last_payload")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type SiteSetting @db(name: "site_settings") {
  createdAt: DateTime! @db(name: "created_at")
  dataType: Int! @db(name: "data_type")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "site_settings_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  updatedAt: DateTime! @db(name: "updated_at")
  value: String
}

type SkippedEmailLog @db(name: "skipped_email_logs") {
  createdAt: DateTime! @db(name: "created_at")
  customReason: String @db(name: "custom_reason")
  emailType: String! @db(name: "email_type")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "skipped_email_logs_id_seq", initialValue: 1, allocationSize: 1)
  postId: Int @db(name: "post_id")
  reasonType: Int! @db(name: "reason_type")
  toAddress: String! @db(name: "to_address")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id")
}

type StylesheetCache @db(name: "stylesheet_cache") {
  content: String!
  createdAt: DateTime @db(name: "created_at")
  digest: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "stylesheet_cache_id_seq", initialValue: 1, allocationSize: 1)
  sourceMap: String @db(name: "source_map")
  target: String!
  themeId: Int! @db(name: "theme_id") @default(value: -1)
  updatedAt: DateTime @db(name: "updated_at")
}

type Tag @db(name: "tags") {
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tags_id_seq", initialValue: 1, allocationSize: 1)
  name: String! @unique
  pmTopicCount: Int! @db(name: "pm_topic_count") @default(value: 0)
  topicCount: Int! @db(name: "topic_count") @default(value: 0)
  updatedAt: DateTime @db(name: "updated_at")
}

type TagGroup @db(name: "tag_groups") {
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tag_groups_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  onePerTopic: Boolean @db(name: "one_per_topic") @default(value: false)
  parentTagId: Int @db(name: "parent_tag_id")
  updatedAt: DateTime @db(name: "updated_at")
}

type TagGroupMembership @db(name: "tag_group_memberships") {
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tag_group_memberships_id_seq", initialValue: 1, allocationSize: 1)
  tagGroupId: Int! @db(name: "tag_group_id")
  tagId: Int! @db(name: "tag_id")
  updatedAt: DateTime @db(name: "updated_at")
}

type TagGroupPermission @db(name: "tag_group_permissions") {
  createdAt: DateTime! @db(name: "created_at")
  groupId: Int! @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tag_group_permissions_id_seq", initialValue: 1, allocationSize: 1)
  permissionType: Int! @db(name: "permission_type") @default(value: 1)
  tagGroupId: Int! @db(name: "tag_group_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type TagSearchDatum @db(name: "tag_search_data") {
  locale: String
  rawData: String @db(name: "raw_data")
  # Type tsvector is not supported
  # searchData: tsvector @db(name: "search_data")
  tag_id: Int! @id(strategy: SEQUENCE) @sequence(name: "tag_search_data_tag_id_seq", initialValue: 1, allocationSize: 1)
  version: Int @default(value: 0)
}

type TagUser @db(name: "tag_users") {
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tag_users_id_seq", initialValue: 1, allocationSize: 1)
  notificationLevel: Int! @db(name: "notification_level")
  tagId: Int! @db(name: "tag_id")
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type Theme @db(name: "themes") {
  colorSchemeId: Int @db(name: "color_scheme_id")
  compilerVersion: Int! @db(name: "compiler_version") @default(value: 0)
  component: Boolean! @default(value: false)
  createdAt: DateTime! @db(name: "created_at")
  hidden: Boolean! @default(value: false)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "themes_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  remoteThemeId: Int @db(name: "remote_theme_id") @unique
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
  userSelectable: Boolean! @db(name: "user_selectable") @default(value: false)
}

type ThemeField @db(name: "theme_fields") {
  compilerVersion: Int! @db(name: "compiler_version") @default(value: 0)
  createdAt: DateTime @db(name: "created_at")
  error: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "theme_fields_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  targetId: Int! @db(name: "target_id")
  themeId: Int! @db(name: "theme_id")
  typeId: Int! @db(name: "type_id") @default(value: 0)
  updatedAt: DateTime @db(name: "updated_at")
  uploadId: Int @db(name: "upload_id")
  value: String!
  valueBaked: String @db(name: "value_baked")
}

type ThemeSetting @db(name: "theme_settings") {
  createdAt: DateTime! @db(name: "created_at")
  dataType: Int! @db(name: "data_type")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "theme_settings_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  themeId: Int! @db(name: "theme_id")
  updatedAt: DateTime! @db(name: "updated_at")
  value: String
}

type Topic @db(name: "topics") {
  archetype: String! @default(value: "regular")
  archived: Boolean! @default(value: false)
  avgTime: Int @db(name: "avg_time")
  bumpedAt: DateTime! @db(name: "bumped_at")
  categoryId: Int @db(name: "category_id")
  closed: Boolean! @default(value: false)
  createdAt: DateTime! @db(name: "created_at")
  deletedAt: DateTime @db(name: "deleted_at")
  deletedById: Int @db(name: "deleted_by_id")
  excerpt: String
  fancyTitle: String @db(name: "fancy_title")
  featuredLink: String @db(name: "featured_link")
  featuredUser1Id: Int @db(name: "featured_user1_id")
  featuredUser2Id: Int @db(name: "featured_user2_id")
  featuredUser3Id: Int @db(name: "featured_user3_id")
  featuredUser4Id: Int @db(name: "featured_user4_id")
  hasSummary: Boolean! @db(name: "has_summary") @default(value: false)
  highestPostNumber: Int! @db(name: "highest_post_number") @default(value: 0)
  highestStaffPostNumber: Int! @db(name: "highest_staff_post_number") @default(value: 0)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topics_id_seq", initialValue: 1, allocationSize: 1)
  imageUrl: String @db(name: "image_url")
  incomingLinkCount: Int! @db(name: "incoming_link_count") @default(value: 0)
  lastPostedAt: DateTime @db(name: "last_posted_at")
  lastPostUserId: Int! @db(name: "last_post_user_id")
  likeCount: Int! @db(name: "like_count") @default(value: 0)
  moderatorPostsCount: Int! @db(name: "moderator_posts_count") @default(value: 0)
  notifyModeratorsCount: Int! @db(name: "notify_moderators_count") @default(value: 0)
  participantCount: Int @db(name: "participant_count") @default(value: 1)
  percentRank: Float! @db(name: "percent_rank") @default(value: 1.0)
  pinnedAt: DateTime @db(name: "pinned_at")
  pinnedGlobally: Boolean! @db(name: "pinned_globally") @default(value: false)
  pinnedUntil: DateTime @db(name: "pinned_until")
  postsCount: Int! @db(name: "posts_count") @default(value: 0)
  replyCount: Int! @db(name: "reply_count") @default(value: 0)
  score: Float
  slug: String
  spamCount: Int! @db(name: "spam_count") @default(value: 0)
  subtype: String
  title: String!
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id")
  views: Int! @default(value: 0)
  visible: Boolean! @default(value: true)
  wordCount: Int @db(name: "word_count")
}

type TopicAllowedGroup @db(name: "topic_allowed_groups") {
  groupId: Int! @db(name: "group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_allowed_groups_id_seq", initialValue: 1, allocationSize: 1)
  topicId: Int! @db(name: "topic_id")
}

type TopicAllowedUser @db(name: "topic_allowed_users") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_allowed_users_id_seq", initialValue: 1, allocationSize: 1)
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type TopicCustomField @db(name: "topic_custom_fields") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_custom_fields_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
  value: String
}

type TopicEmbed @db(name: "topic_embeds") {
  contentSha1: String @db(name: "content_sha1")
  createdAt: DateTime! @db(name: "created_at")
  deletedAt: DateTime @db(name: "deleted_at")
  deletedById: Int @db(name: "deleted_by_id")
  embedUrl: String! @db(name: "embed_url") @unique
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_embeds_id_seq", initialValue: 1, allocationSize: 1)
  postId: Int! @db(name: "post_id")
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type TopicInvite @db(name: "topic_invites") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_invites_id_seq", initialValue: 1, allocationSize: 1)
  inviteId: Int! @db(name: "invite_id")
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type TopicLink @db(name: "topic_links") {
  clicks: Int! @default(value: 0)
  crawledAt: DateTime @db(name: "crawled_at")
  createdAt: DateTime! @db(name: "created_at")
  domain: String!
  extension: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_links_id_seq", initialValue: 1, allocationSize: 1)
  internal: Boolean! @default(value: false)
  linkPostId: Int @db(name: "link_post_id")
  linkTopicId: Int @db(name: "link_topic_id")
  postId: Int @db(name: "post_id")
  quote: Boolean! @default(value: false)
  reflection: Boolean @default(value: false)
  title: String
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
  url: String!
  userId: Int! @db(name: "user_id")
}

type TopicLinkClick @db(name: "topic_link_clicks") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_link_clicks_id_seq", initialValue: 1, allocationSize: 1)
  # Type inet is not supported
  # ipAddress: inet @db(name: "ip_address")
  topicLinkId: Int! @db(name: "topic_link_id")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int @db(name: "user_id")
}

type TopicSearchDatum @db(name: "topic_search_data") {
  locale: String!
  rawData: String @db(name: "raw_data")
  # Type tsvector is not supported
  # searchData: tsvector @db(name: "search_data")
  topic_id: Int! @id
  version: Int @default(value: 0)
}

type TopicTag @db(name: "topic_tags") {
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_tags_id_seq", initialValue: 1, allocationSize: 1)
  tagId: Int! @db(name: "tag_id")
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime @db(name: "updated_at")
}

type TopicTimer @db(name: "topic_timers") {
  basedOnLastPost: Boolean! @db(name: "based_on_last_post") @default(value: false)
  categoryId: Int @db(name: "category_id")
  createdAt: DateTime @db(name: "created_at")
  deletedAt: DateTime @db(name: "deleted_at")
  deletedById: Int @db(name: "deleted_by_id")
  executeAt: DateTime! @db(name: "execute_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_timers_id_seq", initialValue: 1, allocationSize: 1)
  publicType: Boolean @db(name: "public_type") @default(value: true)
  statusType: Int! @db(name: "status_type")
  topicId: Int! @db(name: "topic_id") @unique
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type TopicUser @db(name: "topic_users") {
  bookmarked: Boolean @default(value: false)
  clearedPinnedAt: DateTime @db(name: "cleared_pinned_at")
  firstVisitedAt: DateTime @db(name: "first_visited_at")
  highestSeenPostNumber: Int @db(name: "highest_seen_post_number")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "topic_users_id_seq", initialValue: 1, allocationSize: 1)
  lastEmailedPostNumber: Int @db(name: "last_emailed_post_number")
  lastReadPostNumber: Int @db(name: "last_read_post_number")
  lastVisitedAt: DateTime @db(name: "last_visited_at")
  liked: Boolean @default(value: false)
  notificationLevel: Int! @db(name: "notification_level") @default(value: 1)
  notificationsChangedAt: DateTime @db(name: "notifications_changed_at")
  notificationsReasonId: Int @db(name: "notifications_reason_id")
  posted: Boolean! @default(value: false)
  topicId: Int! @db(name: "topic_id")
  totalMsecsViewed: Int! @db(name: "total_msecs_viewed") @default(value: 0)
  userId: Int! @db(name: "user_id")
}

type TopicView @db(name: "topic_views") {
  # Type inet is not supported
  # ipAddress: inet @db(name: "ip_address")
  topicId: Int! @db(name: "topic_id")
  userId: Int @db(name: "user_id")
  viewedAt: DateTime! @db(name: "viewed_at")
}

type TopTopic @db(name: "top_topics") {
  allScore: Float @db(name: "all_score") @default(value: 0.0)
  dailyLikesCount: Int! @db(name: "daily_likes_count") @default(value: 0)
  dailyOpLikesCount: Int! @db(name: "daily_op_likes_count") @default(value: 0)
  dailyPostsCount: Int! @db(name: "daily_posts_count") @default(value: 0)
  dailyScore: Float @db(name: "daily_score") @default(value: 0.0)
  dailyViewsCount: Int! @db(name: "daily_views_count") @default(value: 0)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "top_topics_id_seq", initialValue: 1, allocationSize: 1)
  monthlyLikesCount: Int! @db(name: "monthly_likes_count") @default(value: 0)
  monthlyOpLikesCount: Int! @db(name: "monthly_op_likes_count") @default(value: 0)
  monthlyPostsCount: Int! @db(name: "monthly_posts_count") @default(value: 0)
  monthlyScore: Float @db(name: "monthly_score") @default(value: 0.0)
  monthlyViewsCount: Int! @db(name: "monthly_views_count") @default(value: 0)
  quarterlyLikesCount: Int! @db(name: "quarterly_likes_count") @default(value: 0)
  quarterlyOpLikesCount: Int! @db(name: "quarterly_op_likes_count") @default(value: 0)
  quarterlyPostsCount: Int! @db(name: "quarterly_posts_count") @default(value: 0)
  quarterlyScore: Float @db(name: "quarterly_score") @default(value: 0.0)
  quarterlyViewsCount: Int! @db(name: "quarterly_views_count") @default(value: 0)
  topicId: Int @db(name: "topic_id") @unique
  weeklyLikesCount: Int! @db(name: "weekly_likes_count") @default(value: 0)
  weeklyOpLikesCount: Int! @db(name: "weekly_op_likes_count") @default(value: 0)
  weeklyPostsCount: Int! @db(name: "weekly_posts_count") @default(value: 0)
  weeklyScore: Float @db(name: "weekly_score") @default(value: 0.0)
  weeklyViewsCount: Int! @db(name: "weekly_views_count") @default(value: 0)
  yearlyLikesCount: Int! @db(name: "yearly_likes_count") @default(value: 0)
  yearlyOpLikesCount: Int! @db(name: "yearly_op_likes_count") @default(value: 0)
  yearlyPostsCount: Int! @db(name: "yearly_posts_count") @default(value: 0)
  yearlyScore: Float @db(name: "yearly_score") @default(value: 0.0)
  yearlyViewsCount: Int! @db(name: "yearly_views_count") @default(value: 0)
}

type TranslationOverride @db(name: "translation_overrides") {
  compiledJs: String @db(name: "compiled_js")
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "translation_overrides_id_seq", initialValue: 1, allocationSize: 1)
  locale: String!
  translationKey: String! @db(name: "translation_key")
  updatedAt: DateTime! @db(name: "updated_at")
  value: String!
}

type TwitterUserInfo @db(name: "twitter_user_infos") {
  createdAt: DateTime! @db(name: "created_at")
  email: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "twitter_user_infos_id_seq", initialValue: 1, allocationSize: 1)
  screenName: String! @db(name: "screen_name")
  twitterUserId: Int! @db(name: "twitter_user_id") @unique
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id") @unique
}

type UnsubscribeKey @db(name: "unsubscribe_keys") {
  createdAt: DateTime @db(name: "created_at")
  key: ID! @id
  postId: Int @db(name: "post_id")
  topicId: Int @db(name: "topic_id")
  unsubscribeKeyType: String @db(name: "unsubscribe_key_type")
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type Upload @db(name: "uploads") {
  createdAt: DateTime! @db(name: "created_at")
  extension: String
  filesize: Int!
  height: Int
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "uploads_id_seq", initialValue: 1, allocationSize: 1)
  origin: String
  originalFilename: String! @db(name: "original_filename")
  retainHours: Int @db(name: "retain_hours")
  sha1: String @unique
  thumbnailHeight: Int @db(name: "thumbnail_height")
  thumbnailWidth: Int @db(name: "thumbnail_width")
  updatedAt: DateTime! @db(name: "updated_at")
  url: String!
  userId: Int! @db(name: "user_id")
  width: Int
}

type User @db(name: "users") {
  active: Boolean! @default(value: false)
  admin: Boolean! @default(value: false)
  approved: Boolean! @default(value: false)
  approvedAt: DateTime @db(name: "approved_at")
  approvedById: Int @db(name: "approved_by_id")
  createdAt: DateTime! @db(name: "created_at")
  dateOfBirth: DateTime @db(name: "date_of_birth")
  firstSeenAt: DateTime @db(name: "first_seen_at")
  flagLevel: Int! @db(name: "flag_level") @default(value: 0)
  groupLockedTrustLevel: Int @db(name: "group_locked_trust_level")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "users_id_seq", initialValue: 1, allocationSize: 1)
  # Type inet is not supported
  # ipAddress: inet @db(name: "ip_address")
  lastEmailedAt: DateTime @db(name: "last_emailed_at")
  lastPostedAt: DateTime @db(name: "last_posted_at")
  lastSeenAt: DateTime @db(name: "last_seen_at")
  locale: String
  manualLockedTrustLevel: Int @db(name: "manual_locked_trust_level")
  moderator: Boolean @default(value: false)
  name: String
  passwordHash: String @db(name: "password_hash")
  previousVisitAt: DateTime @db(name: "previous_visit_at")
  primaryGroupId: Int @db(name: "primary_group_id")
  # Type inet is not supported
  # registrationIpAddress: inet @db(name: "registration_ip_address")
  salt: String
  seenNotificationId: Int! @db(name: "seen_notification_id") @default(value: 0)
  silencedTill: DateTime @db(name: "silenced_till")
  staged: Boolean! @default(value: false)
  suspendedAt: DateTime @db(name: "suspended_at")
  suspendedTill: DateTime @db(name: "suspended_till")
  title: String
  trustLevel: Int! @db(name: "trust_level")
  updatedAt: DateTime! @db(name: "updated_at")
  uploadedAvatarId: Int @db(name: "uploaded_avatar_id")
  username: String! @unique
  usernameLower: String! @db(name: "username_lower") @unique
  views: Int! @default(value: 0)
}

type UserAction @db(name: "user_actions") {
  actingUserId: Int @db(name: "acting_user_id")
  actionType: Int! @db(name: "action_type")
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_actions_id_seq", initialValue: 1, allocationSize: 1)
  queuedPostId: Int @db(name: "queued_post_id")
  targetPostId: Int @db(name: "target_post_id")
  targetTopicId: Int @db(name: "target_topic_id")
  targetUserId: Int @db(name: "target_user_id")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type UserApiKey @db(name: "user_api_keys") {
  applicationName: String! @db(name: "application_name")
  clientId: String! @db(name: "client_id") @unique
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_api_keys_id_seq", initialValue: 1, allocationSize: 1)
  key: String! @unique
  lastUsedAt: DateTime! @db(name: "last_used_at")
  pushUrl: String @db(name: "push_url")
  revokedAt: DateTime @db(name: "revoked_at")
  scopes: String! @default(value: "{}")
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type UserArchivedMessage @db(name: "user_archived_messages") {
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_archived_messages_id_seq", initialValue: 1, allocationSize: 1)
  topicId: Int! @db(name: "topic_id")
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type UserAuthToken @db(name: "user_auth_tokens") {
  authToken: String! @db(name: "auth_token") @unique
  authTokenSeen: Boolean! @db(name: "auth_token_seen") @default(value: false)
  # Type inet is not supported
  # clientIp: inet @db(name: "client_ip")
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_auth_tokens_id_seq", initialValue: 1, allocationSize: 1)
  prevAuthToken: String! @db(name: "prev_auth_token") @unique
  rotatedAt: DateTime! @db(name: "rotated_at")
  seenAt: DateTime @db(name: "seen_at")
  updatedAt: DateTime @db(name: "updated_at")
  userAgent: String @db(name: "user_agent")
  userId: Int! @db(name: "user_id")
}

type UserAuthTokenLog @db(name: "user_auth_token_logs") {
  action: String!
  authToken: String @db(name: "auth_token")
  # Type inet is not supported
  # clientIp: inet @db(name: "client_ip")
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_auth_token_logs_id_seq", initialValue: 1, allocationSize: 1)
  path: String
  userAgent: String @db(name: "user_agent")
  userAuthTokenId: Int @db(name: "user_auth_token_id")
  userId: Int @db(name: "user_id")
}

type UserAvatar @db(name: "user_avatars") {
  createdAt: DateTime! @db(name: "created_at")
  customUploadId: Int @db(name: "custom_upload_id")
  gravatarUploadId: Int @db(name: "gravatar_upload_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_avatars_id_seq", initialValue: 1, allocationSize: 1)
  lastGravatarDownloadAttempt: DateTime @db(name: "last_gravatar_download_attempt")
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type UserBadge @db(name: "user_badges") {
  badgeId: Int! @db(name: "badge_id")
  grantedAt: DateTime! @db(name: "granted_at")
  grantedById: Int! @db(name: "granted_by_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_badges_id_seq", initialValue: 1, allocationSize: 1)
  notificationId: Int @db(name: "notification_id")
  postId: Int @db(name: "post_id")
  seq: Int! @default(value: 0)
  userId: Int! @db(name: "user_id")
}

type UserCustomField @db(name: "user_custom_fields") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_custom_fields_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
  value: String
}

type UserEmail @db(name: "user_emails") {
  createdAt: DateTime @db(name: "created_at")
  email: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_emails_id_seq", initialValue: 1, allocationSize: 1)
  primary: Boolean! @default(value: false)
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type UserExport @db(name: "user_exports") {
  createdAt: DateTime @db(name: "created_at")
  fileName: String! @db(name: "file_name")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_exports_id_seq", initialValue: 1, allocationSize: 1)
  updatedAt: DateTime @db(name: "updated_at")
  uploadId: Int @db(name: "upload_id")
  userId: Int! @db(name: "user_id")
}

type UserField @db(name: "user_fields") {
  createdAt: DateTime @db(name: "created_at")
  description: String!
  editable: Boolean! @default(value: false)
  externalName: String @db(name: "external_name")
  externalType: String @db(name: "external_type")
  fieldType: String! @db(name: "field_type")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_fields_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
  position: Int @default(value: 0)
  required: Boolean! @default(value: true)
  showOnProfile: Boolean! @db(name: "show_on_profile") @default(value: false)
  showOnUserCard: Boolean! @db(name: "show_on_user_card") @default(value: false)
  updatedAt: DateTime @db(name: "updated_at")
}

type UserFieldOption @db(name: "user_field_options") {
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_field_options_id_seq", initialValue: 1, allocationSize: 1)
  updatedAt: DateTime @db(name: "updated_at")
  userFieldId: Int! @db(name: "user_field_id")
  value: String!
}

type UserHistory @db(name: "user_histories") {
  actingUserId: Int @db(name: "acting_user_id")
  action: Int!
  adminOnly: Boolean @db(name: "admin_only") @default(value: false)
  categoryId: Int @db(name: "category_id")
  context: String
  createdAt: DateTime! @db(name: "created_at")
  customType: String @db(name: "custom_type")
  details: String
  email: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_histories_id_seq", initialValue: 1, allocationSize: 1)
  ipAddress: String @db(name: "ip_address")
  newValue: String @db(name: "new_value")
  postId: Int @db(name: "post_id")
  previousValue: String @db(name: "previous_value")
  subject: String
  targetUserId: Int @db(name: "target_user_id")
  topicId: Int @db(name: "topic_id")
  updatedAt: DateTime! @db(name: "updated_at")
}

type UserOpenId @db(name: "user_open_ids") {
  active: Boolean!
  createdAt: DateTime! @db(name: "created_at")
  email: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_open_ids_id_seq", initialValue: 1, allocationSize: 1)
  updatedAt: DateTime! @db(name: "updated_at")
  url: String!
  userId: Int! @db(name: "user_id")
}

type UserOption @db(name: "user_options") {
  allowPrivateMessages: Boolean! @db(name: "allow_private_messages") @default(value: true)
  automaticallyUnpinTopics: Boolean! @db(name: "automatically_unpin_topics") @default(value: true)
  autoTrackTopicsAfterMsecs: Int @db(name: "auto_track_topics_after_msecs")
  digestAfterMinutes: Int @db(name: "digest_after_minutes")
  disableJumpReply: Boolean! @db(name: "disable_jump_reply") @default(value: false)
  dynamicFavicon: Boolean! @db(name: "dynamic_favicon") @default(value: false)
  emailAlways: Boolean! @db(name: "email_always") @default(value: false)
  emailDigests: Boolean @db(name: "email_digests")
  emailDirect: Boolean! @db(name: "email_direct") @default(value: true)
  emailInReplyTo: Boolean! @db(name: "email_in_reply_to") @default(value: true)
  emailPreviousReplies: Int! @db(name: "email_previous_replies") @default(value: 2)
  emailPrivateMessages: Boolean! @db(name: "email_private_messages") @default(value: true)
  enableQuoting: Boolean! @db(name: "enable_quoting") @default(value: true)
  externalLinksInNewTab: Boolean! @db(name: "external_links_in_new_tab") @default(value: false)
  hideProfileAndPresence: Boolean! @db(name: "hide_profile_and_presence") @default(value: false)
  homepageId: Int @db(name: "homepage_id")
  includeTl0InDigests: Boolean @db(name: "include_tl0_in_digests") @default(value: false)
  lastRedirectedToTopAt: DateTime @db(name: "last_redirected_to_top_at")
  likeNotificationFrequency: Int! @db(name: "like_notification_frequency") @default(value: 1)
  mailingListMode: Boolean! @db(name: "mailing_list_mode") @default(value: false)
  mailingListModeFrequency: Int! @db(name: "mailing_list_mode_frequency") @default(value: 1)
  newTopicDurationMinutes: Int @db(name: "new_topic_duration_minutes")
  notificationLevelWhenReplying: Int @db(name: "notification_level_when_replying")
  themeIds: Int! @db(name: "theme_ids")
  themeKeySeq: Int! @db(name: "theme_key_seq") @default(value: 0)
  user_id: Int! @id
}

type UserProfile @db(name: "user_profiles") {
  badgeGrantedTitle: Boolean @db(name: "badge_granted_title") @default(value: false)
  bioCooked: String @db(name: "bio_cooked")
  bioCookedVersion: Int @db(name: "bio_cooked_version")
  bioRaw: String @db(name: "bio_raw")
  cardBackground: String @db(name: "card_background")
  dismissedBannerKey: Int @db(name: "dismissed_banner_key")
  location: String
  profileBackground: String @db(name: "profile_background")
  user_id: Int! @id
  views: Int! @default(value: 0)
  website: String
}

type UserProfileView @db(name: "user_profile_views") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_profile_views_id_seq", initialValue: 1, allocationSize: 1)
  # Type inet is not supported
  # ipAddress: inet @db(name: "ip_address")
  userId: Int @db(name: "user_id")
  userProfileId: Int! @db(name: "user_profile_id")
  viewedAt: DateTime! @db(name: "viewed_at")
}

type UserSearchDatum @db(name: "user_search_data") {
  locale: String
  rawData: String @db(name: "raw_data")
  # Type tsvector is not supported
  # searchData: tsvector @db(name: "search_data")
  user_id: Int! @id
  version: Int @default(value: 0)
}

type UserSecondFactor @db(name: "user_second_factors") {
  createdAt: DateTime! @db(name: "created_at")
  data: String!
  enabled: Boolean! @default(value: false)
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_second_factors_id_seq", initialValue: 1, allocationSize: 1)
  lastUsed: DateTime @db(name: "last_used")
  method: Int!
  updatedAt: DateTime! @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type UserStat @db(name: "user_stats") {
  bounceScore: Float! @db(name: "bounce_score") @default(value: 0)
  daysVisited: Int! @db(name: "days_visited") @default(value: 0)
  firstPostCreatedAt: DateTime @db(name: "first_post_created_at")
  likesGiven: Int! @db(name: "likes_given") @default(value: 0)
  likesReceived: Int! @db(name: "likes_received") @default(value: 0)
  newSince: DateTime! @db(name: "new_since")
  postCount: Int! @db(name: "post_count") @default(value: 0)
  postsReadCount: Int! @db(name: "posts_read_count") @default(value: 0)
  readFaq: DateTime @db(name: "read_faq")
  resetBounceScoreAfter: DateTime @db(name: "reset_bounce_score_after")
  timeRead: Int! @db(name: "time_read") @default(value: 0)
  topicCount: Int! @db(name: "topic_count") @default(value: 0)
  topicReplyCount: Int! @db(name: "topic_reply_count") @default(value: 0)
  topicsEntered: Int! @db(name: "topics_entered") @default(value: 0)
  user_id: Int! @id
}

type UserUpload @db(name: "user_uploads") {
  createdAt: DateTime! @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_uploads_id_seq", initialValue: 1, allocationSize: 1)
  uploadId: Int! @db(name: "upload_id")
  userId: Int! @db(name: "user_id")
}

type UserVisit @db(name: "user_visits") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_visits_id_seq", initialValue: 1, allocationSize: 1)
  mobile: Boolean @default(value: false)
  postsRead: Int @db(name: "posts_read") @default(value: 0)
  timeRead: Int! @db(name: "time_read") @default(value: 0)
  userId: Int! @db(name: "user_id")
  visitedAt: DateTime! @db(name: "visited_at")
}

type UserWarning @db(name: "user_warnings") {
  createdAt: DateTime @db(name: "created_at")
  createdById: Int! @db(name: "created_by_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "user_warnings_id_seq", initialValue: 1, allocationSize: 1)
  topicId: Int! @db(name: "topic_id") @unique
  updatedAt: DateTime @db(name: "updated_at")
  userId: Int! @db(name: "user_id")
}

type WatchedWord @db(name: "watched_words") {
  action: Int!
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "watched_words_id_seq", initialValue: 1, allocationSize: 1)
  updatedAt: DateTime @db(name: "updated_at")
  word: String!
}

type WebCrawlerRequest @db(name: "web_crawler_requests") {
  count: Int! @default(value: 0)
  date: DateTime!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "web_crawler_requests_id_seq", initialValue: 1, allocationSize: 1)
  userAgent: String! @db(name: "user_agent")
}

type WebHook @db(name: "web_hooks") {
  active: Boolean! @default(value: false)
  contentType: Int! @db(name: "content_type") @default(value: 1)
  createdAt: DateTime @db(name: "created_at")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "web_hooks_id_seq", initialValue: 1, allocationSize: 1)
  lastDeliveryStatus: Int! @db(name: "last_delivery_status") @default(value: 1)
  payloadUrl: String! @db(name: "payload_url")
  secret: String @default(value: "")
  status: Int! @default(value: 1)
  updatedAt: DateTime @db(name: "updated_at")
  verifyCertificate: Boolean! @db(name: "verify_certificate") @default(value: true)
  wildcardWebHook: Boolean! @db(name: "wildcard_web_hook") @default(value: false)
}

type WebHookEvent @db(name: "web_hook_events") {
  createdAt: DateTime @db(name: "created_at")
  duration: Int @default(value: 0)
  headers: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "web_hook_events_id_seq", initialValue: 1, allocationSize: 1)
  payload: String
  responseBody: String @db(name: "response_body")
  responseHeaders: String @db(name: "response_headers")
  status: Int @default(value: 0)
  updatedAt: DateTime @db(name: "updated_at")
  webHookId: Int! @db(name: "web_hook_id")
}

type WebHookEventType @db(name: "web_hook_event_types") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "web_hook_event_types_id_seq", initialValue: 1, allocationSize: 1)
  name: String!
}

type WebHookEventTypesHook @db(name: "web_hook_event_types_hooks") {
  webHookEventTypeId: Int! @db(name: "web_hook_event_type_id")
  webHookId: Int! @db(name: "web_hook_id")
}
