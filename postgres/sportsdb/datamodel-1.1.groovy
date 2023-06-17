type Address @db(name: "addresses") {
  building: String
  country: String
  county: String
  district: String
  floor: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "addresses_id_seq", initialValue: 1, allocationSize: 1)
  language: String
  locality: String
  location: Location! @db(name: "location_id")
  neighborhood: String
  postalCode: String @db(name: "postal_code")
  region: String
  street: String
  streetNumber: String @db(name: "street_number")
  streetPrefix: String @db(name: "street_prefix")
  streetSuffix: String @db(name: "street_suffix")
  suite: String
}

type Affiliation @db(name: "affiliations") {
  affiliationKey: String! @db(name: "affiliation_key")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references AffiliationPhase.ancestorAffiliation.
  # affiliationPhases: [AffiliationPhase] @relation(name: "AffiliationAffiliationPhasesToAffiliationPhaseAncestorAffiliation")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references AffiliationPhase.affiliation.
  # affiliationPhases: [AffiliationPhase] @relation(name: "AffiliationAffiliationPhasesToAffiliationPhaseAffiliation")
  affiliationsDocuments: [AffiliationsDocument]
  affiliationsEvents: [AffiliationsEvent]
  affiliationsMedia: [AffiliationsMedia]
  affiliationType: String @db(name: "affiliation_type")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "affiliations_id_seq", initialValue: 1, allocationSize: 1)
  positions: [Position]
  publisher: Publisher! @db(name: "publisher_id")
  seasons: [Season]
  standings: [Standing]
  standingSubgroups: [StandingSubgroup]
  teamPhases: [TeamPhase]
}

type AffiliationPhase @db(name: "affiliation_phases") {
  affiliation: Affiliation! @db(name: "affiliation_id") @relation(name: "AffiliationAffiliationPhasesToAffiliationPhaseAffiliation")
  ancestorAffiliation: Affiliation @db(name: "ancestor_affiliation_id") @relation(name: "AffiliationAffiliationPhasesToAffiliationPhaseAncestorAffiliation")
  endDateTime: DateTime @db(name: "end_date_time")
  endSeason: Season @db(name: "end_season_id") @relation(name: "AffiliationPhaseEndSeasonToSeasonAffiliationPhases")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "affiliation_phases_id_seq", initialValue: 1, allocationSize: 1)
  startDateTime: DateTime @db(name: "start_date_time")
  startSeason: Season @db(name: "start_season_id") @relation(name: "AffiliationPhaseStartSeasonToSeasonAffiliationPhases")
}

type AffiliationsDocument @db(name: "affiliations_documents") @linkTable {
  affiliation: Affiliation! @db(name: "affiliation_id")
  document: Document! @db(name: "document_id")
}

type AffiliationsEvent @db(name: "affiliations_events") @linkTable {
  affiliation: Affiliation! @db(name: "affiliation_id")
  event: Event! @db(name: "event_id")
}

type AffiliationsMedia @db(name: "affiliations_media") @linkTable {
  affiliation: Affiliation! @db(name: "affiliation_id")
  media: Media! @db(name: "media_id")
}

type AmericanFootballActionParticipant @db(name: "american_football_action_participants") {
  americanFootballActionPlay: AmericanFootballActionPlay! @db(name: "american_football_action_play_id")
  fieldLine: Int @db(name: "field_line")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_action_participants_id_seq", initialValue: 1, allocationSize: 1)
  participantRole: String! @db(name: "participant_role")
  person: Person! @db(name: "person_id")
  scoreCredit: Int @db(name: "score_credit")
  scoreType: String @db(name: "score_type")
  yardage: Int
  yardsGained: Int @db(name: "yards_gained")
}

type AmericanFootballActionPlay @db(name: "american_football_action_plays") {
  americanFootballActionParticipants: [AmericanFootballActionParticipant]
  americanFootballEventState: AmericanFootballEventState! @db(name: "american_football_event_state_id")
  comment: String
  driveResult: String @db(name: "drive_result")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_action_plays_id_seq", initialValue: 1, allocationSize: 1)
  playType: String @db(name: "play_type")
  points: Int
  scoreAttemptType: String @db(name: "score_attempt_type")
}

type AmericanFootballDefensiveStat @db(name: "american_football_defensive_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_defensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  interceptionsAverage: String @db(name: "interceptions_average")
  interceptionsLongest: String @db(name: "interceptions_longest")
  interceptionsTotal: String @db(name: "interceptions_total")
  interceptionsTouchdown: String @db(name: "interceptions_touchdown")
  interceptionsYards: String @db(name: "interceptions_yards")
  passesDefensed: String @db(name: "passes_defensed")
  quarterbackHurries: String @db(name: "quarterback_hurries")
  sacksTotal: String @db(name: "sacks_total")
  sacksYards: String @db(name: "sacks_yards")
  tacklesAssists: String @db(name: "tackles_assists")
  tacklesSolo: String @db(name: "tackles_solo")
  tacklesTotal: String @db(name: "tackles_total")
}

type AmericanFootballDownProgressStat @db(name: "american_football_down_progress_stats") {
  conversionsFourthDown: String @db(name: "conversions_fourth_down")
  conversionsFourthDownAttempts: String @db(name: "conversions_fourth_down_attempts")
  conversionsFourthDownPercentage: String @db(name: "conversions_fourth_down_percentage")
  conversionsThirdDown: String @db(name: "conversions_third_down")
  conversionsThirdDownAttempts: String @db(name: "conversions_third_down_attempts")
  conversionsThirdDownPercentage: String @db(name: "conversions_third_down_percentage")
  firstDownsPass: String @db(name: "first_downs_pass")
  firstDownsPenalty: String @db(name: "first_downs_penalty")
  firstDownsRun: String @db(name: "first_downs_run")
  firstDownsTotal: String @db(name: "first_downs_total")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_down_progress_stats_id_seq", initialValue: 1, allocationSize: 1)
}

type AmericanFootballEventState @db(name: "american_football_event_states") {
  americanFootballActionPlays: [AmericanFootballActionPlay]
  clockState: String @db(name: "clock_state")
  context: String
  currentState: Int @db(name: "current_state")
  distanceFor1stDown: Int @db(name: "distance_for_1st_down")
  down: Int
  event: Event! @db(name: "event_id")
  fieldLine: Int @db(name: "field_line")
  fieldSide: String @db(name: "field_side")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_event_states_id_seq", initialValue: 1, allocationSize: 1)
  periodTimeElapsed: String @db(name: "period_time_elapsed")
  periodTimeRemaining: String @db(name: "period_time_remaining")
  periodValue: Int @db(name: "period_value")
  sequenceNumber: Int @db(name: "sequence_number")
  teamInPossession: Team @db(name: "team_in_possession_id")
}

type AmericanFootballFumblesStat @db(name: "american_football_fumbles_stats") {
  fumblesCommitted: String @db(name: "fumbles_committed")
  fumblesForced: String @db(name: "fumbles_forced")
  fumblesLost: String @db(name: "fumbles_lost")
  fumblesOpposingCommitted: String @db(name: "fumbles_opposing_committed")
  fumblesOpposingLost: String @db(name: "fumbles_opposing_lost")
  fumblesOpposingRecovered: String @db(name: "fumbles_opposing_recovered")
  fumblesOpposingYardsGained: String @db(name: "fumbles_opposing_yards_gained")
  fumblesOwnCommitted: String @db(name: "fumbles_own_committed")
  fumblesOwnLost: String @db(name: "fumbles_own_lost")
  fumblesOwnRecovered: String @db(name: "fumbles_own_recovered")
  fumblesOwnYardsGained: String @db(name: "fumbles_own_yards_gained")
  fumblesRecovered: String @db(name: "fumbles_recovered")
  fumblesYardsGained: String @db(name: "fumbles_yards_gained")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_fumbles_stats_id_seq", initialValue: 1, allocationSize: 1)
}

type AmericanFootballOffensiveStat @db(name: "american_football_offensive_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_offensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  offensivePlaysAverageYardsPer: String @db(name: "offensive_plays_average_yards_per")
  offensivePlaysNumber: String @db(name: "offensive_plays_number")
  offensivePlaysYards: String @db(name: "offensive_plays_yards")
  possessionDuration: String @db(name: "possession_duration")
  turnoversGiveaway: String @db(name: "turnovers_giveaway")
}

type AmericanFootballPassingStat @db(name: "american_football_passing_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_passing_stats_id_seq", initialValue: 1, allocationSize: 1)
  passerRating: String @db(name: "passer_rating")
  passesAttempts: String @db(name: "passes_attempts")
  passesAverageYardsPer: String @db(name: "passes_average_yards_per")
  passesCompletions: String @db(name: "passes_completions")
  passesInterceptions: String @db(name: "passes_interceptions")
  passesInterceptionsPercentage: String @db(name: "passes_interceptions_percentage")
  passesLongest: String @db(name: "passes_longest")
  passesPercentage: String @db(name: "passes_percentage")
  passesTouchdowns: String @db(name: "passes_touchdowns")
  passesTouchdownsPercentage: String @db(name: "passes_touchdowns_percentage")
  passesYardsGross: String @db(name: "passes_yards_gross")
  passesYardsLost: String @db(name: "passes_yards_lost")
  passesYardsNet: String @db(name: "passes_yards_net")
  receptionsAverageYardsPer: String @db(name: "receptions_average_yards_per")
  receptionsFirstDown: String @db(name: "receptions_first_down")
  receptionsLongest: String @db(name: "receptions_longest")
  receptionsTotal: String @db(name: "receptions_total")
  receptionsTouchdowns: String @db(name: "receptions_touchdowns")
  receptionsYards: String @db(name: "receptions_yards")
}

type AmericanFootballPenaltiesStat @db(name: "american_football_penalties_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_penalties_stats_id_seq", initialValue: 1, allocationSize: 1)
  penaltiesTotal: String @db(name: "penalties_total")
  penaltyFirstDowns: String @db(name: "penalty_first_downs")
  penaltyYards: String @db(name: "penalty_yards")
}

type AmericanFootballRushingStat @db(name: "american_football_rushing_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_rushing_stats_id_seq", initialValue: 1, allocationSize: 1)
  rushesAttempts: String @db(name: "rushes_attempts")
  rushesFirstDown: String @db(name: "rushes_first_down")
  rushesLongest: String @db(name: "rushes_longest")
  rushesTouchdowns: String @db(name: "rushes_touchdowns")
  rushesYards: String @db(name: "rushes_yards")
  rushingAverageYardsPer: String @db(name: "rushing_average_yards_per")
}

type AmericanFootballSacksAgainstStat @db(name: "american_football_sacks_against_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_sacks_against_stats_id_seq", initialValue: 1, allocationSize: 1)
  sacksAgainstTotal: String @db(name: "sacks_against_total")
  sacksAgainstYards: String @db(name: "sacks_against_yards")
}

type AmericanFootballScoringStat @db(name: "american_football_scoring_stats") {
  extraPointsAttempts: String @db(name: "extra_points_attempts")
  extraPointsBlocked: String @db(name: "extra_points_blocked")
  extraPointsMade: String @db(name: "extra_points_made")
  extraPointsMissed: String @db(name: "extra_points_missed")
  fieldGoalAttempts: String @db(name: "field_goal_attempts")
  fieldGoalsBlocked: String @db(name: "field_goals_blocked")
  fieldGoalsMade: String @db(name: "field_goals_made")
  fieldGoalsMissed: String @db(name: "field_goals_missed")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_scoring_stats_id_seq", initialValue: 1, allocationSize: 1)
  safetiesAgainst: String @db(name: "safeties_against")
  touchbacksTotal: String @db(name: "touchbacks_total")
  touchdownsDefensive: String @db(name: "touchdowns_defensive")
  touchdownsPassing: String @db(name: "touchdowns_passing")
  touchdownsRushing: String @db(name: "touchdowns_rushing")
  touchdownsSpecialTeams: String @db(name: "touchdowns_special_teams")
  touchdownsTotal: String @db(name: "touchdowns_total")
  twoPointConversionsAttempts: String @db(name: "two_point_conversions_attempts")
  twoPointConversionsMade: String @db(name: "two_point_conversions_made")
}

type AmericanFootballSpecialTeamsStat @db(name: "american_football_special_teams_stats") {
  fairCatches: String @db(name: "fair_catches")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "american_football_special_teams_stats_id_seq", initialValue: 1, allocationSize: 1)
  puntsAverage: String @db(name: "punts_average")
  puntsBlocked: String @db(name: "punts_blocked")
  puntsInside20: String @db(name: "punts_inside_20")
  puntsInside20Percentage: String @db(name: "punts_inside_20_percentage")
  puntsLongest: String @db(name: "punts_longest")
  puntsTotal: String @db(name: "punts_total")
  puntsYardsGross: String @db(name: "punts_yards_gross")
  puntsYardsNet: String @db(name: "punts_yards_net")
  returnsKickoffAverage: String @db(name: "returns_kickoff_average")
  returnsKickoffLongest: String @db(name: "returns_kickoff_longest")
  returnsKickoffTotal: String @db(name: "returns_kickoff_total")
  returnsKickoffTouchdown: String @db(name: "returns_kickoff_touchdown")
  returnsKickoffYards: String @db(name: "returns_kickoff_yards")
  returnsPuntAverage: String @db(name: "returns_punt_average")
  returnsPuntLongest: String @db(name: "returns_punt_longest")
  returnsPuntTotal: String @db(name: "returns_punt_total")
  returnsPuntTouchdown: String @db(name: "returns_punt_touchdown")
  returnsPuntYards: String @db(name: "returns_punt_yards")
  returnsTotal: String @db(name: "returns_total")
  returnsYards: String @db(name: "returns_yards")
  touchbacksInterceptions: String @db(name: "touchbacks_interceptions")
  touchbacksInterceptionsPercentage: String @db(name: "touchbacks_interceptions_percentage")
  touchbacksKickoffs: String @db(name: "touchbacks_kickoffs")
  touchbacksKickoffsPercentage: String @db(name: "touchbacks_kickoffs_percentage")
  touchbacksPunts: String @db(name: "touchbacks_punts")
  touchbacksPuntsPercentage: String @db(name: "touchbacks_punts_percentage")
  touchbacksTotal: String @db(name: "touchbacks_total")
  touchbacksTotalPercentage: String @db(name: "touchbacks_total_percentage")
}

type BaseballActionContactDetail @db(name: "baseball_action_contact_details") {
  baseballActionPitch: BaseballActionPitch! @db(name: "baseball_action_pitch_id")
  comment: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_action_contact_details_id_seq", initialValue: 1, allocationSize: 1)
  location: String
  strength: String
  trajectoryCoordinates: String @db(name: "trajectory_coordinates")
  trajectoryFormula: String @db(name: "trajectory_formula")
  velocity: Int
}

type BaseballActionPitch @db(name: "baseball_action_pitches") {
  ballType: String @db(name: "ball_type")
  baseballActionContactDetails: [BaseballActionContactDetail]
  baseballActionPlay: BaseballActionPlay! @db(name: "baseball_action_play_id")
  baseballDefensiveGroup: BaseballDefensiveGroup @db(name: "baseball_defensive_group_id")
  comment: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_action_pitches_id_seq", initialValue: 1, allocationSize: 1)
  pitchLocation: String @db(name: "pitch_location")
  pitchType: String @db(name: "pitch_type")
  pitchVelocity: Int @db(name: "pitch_velocity")
  sequenceNumber: Int @db(name: "sequence_number")
  strikeType: String @db(name: "strike_type")
  trajectoryCoordinates: String @db(name: "trajectory_coordinates")
  trajectoryFormula: String @db(name: "trajectory_formula")
  umpireCall: String @db(name: "umpire_call")
}

type BaseballActionPlay @db(name: "baseball_action_plays") {
  baseballActionPitches: [BaseballActionPitch]
  baseballDefensiveGroupId: Int @db(name: "baseball_defensive_group_id")
  baseballEventState: BaseballEventState! @db(name: "baseball_event_state_id")
  comment: String
  earnedRunsScored: String @db(name: "earned_runs_scored")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_action_plays_id_seq", initialValue: 1, allocationSize: 1)
  notation: String
  notationYaml: String @db(name: "notation_yaml")
  outsRecorded: Int @db(name: "outs_recorded")
  playType: String @db(name: "play_type")
  rbi: Int
  runnerOnFirstAdvance: Int @db(name: "runner_on_first_advance")
  runnerOnSecondAdvance: Int @db(name: "runner_on_second_advance")
  runnerOnThirdAdvance: Int @db(name: "runner_on_third_advance")
  runsScored: Int @db(name: "runs_scored")
}

type BaseballActionSubstitution @db(name: "baseball_action_substitutions") {
  baseballEventState: BaseballEventState! @db(name: "baseball_event_state_id")
  comment: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_action_substitutions_id_seq", initialValue: 1, allocationSize: 1)
  personOriginal: Person @db(name: "person_original_id") @relation(name: "BaseballActionSubstitutionPersonOriginalToPersonBaseballActionSubstitutions")
  personOriginalLineupSlot: Int @db(name: "person_original_lineup_slot")
  personOriginalPosition: Position @db(name: "person_original_position_id") @relation(name: "BaseballActionSubstitutionPersonOriginalPositionToPositionBaseballActionSubstitutions")
  personReplacing: Person @db(name: "person_replacing_id") @relation(name: "BaseballActionSubstitutionPersonReplacingToPersonBaseballActionSubstitutions")
  personReplacingLineupSlot: Int @db(name: "person_replacing_lineup_slot")
  personReplacingPosition: Position @db(name: "person_replacing_position_id") @relation(name: "BaseballActionSubstitutionPersonReplacingPositionToPositionBaseballActionSubstitutions")
  personType: String @db(name: "person_type")
  sequenceNumber: Int @db(name: "sequence_number")
  substitutionReason: String @db(name: "substitution_reason")
}

type BaseballDefensiveGroup @db(name: "baseball_defensive_group") @linkTable {
  baseballActionPitches: [BaseballActionPitch]
  baseballDefensivePlayers: [BaseballDefensivePlayer]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_defensive_group_id_seq", initialValue: 1, allocationSize: 1)
}

type BaseballDefensivePlayer @db(name: "baseball_defensive_players") {
  baseballDefensiveGroup: BaseballDefensiveGroup! @db(name: "baseball_defensive_group_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_defensive_players_id_seq", initialValue: 1, allocationSize: 1)
  player: Person! @db(name: "player_id")
  position: Position! @db(name: "position_id")
}

type BaseballDefensiveStat @db(name: "baseball_defensive_stats") {
  assists: Int
  defensiveAverage: Float @db(name: "defensive_average")
  doublePlays: Int @db(name: "double_plays")
  errors: Int
  errorsCatchersInterference: Int @db(name: "errors_catchers_interference")
  errorsPassedBall: Int @db(name: "errors_passed_ball")
  fieldingPercentage: Float @db(name: "fielding_percentage")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_defensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  putouts: Int
  triplePlays: Int @db(name: "triple_plays")
}

type BaseballEventState @db(name: "baseball_event_states") {
  atBatNumber: Int @db(name: "at_bat_number")
  balls: Int
  baseballActionPlays: [BaseballActionPlay]
  baseballActionSubstitutions: [BaseballActionSubstitution]
  batter: Person @db(name: "batter_id") @relation(name: "BaseballEventStateBatterToPersonBaseballEventStates")
  batterSide: String @db(name: "batter_side")
  context: String
  currentState: Int @db(name: "current_state")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_event_states_id_seq", initialValue: 1, allocationSize: 1)
  inningHalf: String @db(name: "inning_half")
  inningValue: Int @db(name: "inning_value")
  outs: Int
  pitcher: Person @db(name: "pitcher_id") @relation(name: "BaseballEventStatePitcherToPersonBaseballEventStates")
  # Field name normalization failed because of a conflicting field name.
  runner_on_first_id: Person @relation(name: "BaseballEventStateRunner_on_first_idToPersonBaseballEventStates")
  # Field name normalization failed because of a conflicting field name.
  runner_on_second_id: Person @relation(name: "BaseballEventStateRunner_on_second_idToPersonBaseballEventStates")
  # Field name normalization failed because of a conflicting field name.
  runner_on_third_id: Person @relation(name: "BaseballEventStateRunner_on_third_idToPersonBaseballEventStates")
  runnerOnFirst: Int @db(name: "runner_on_first")
  runnerOnSecond: Int @db(name: "runner_on_second")
  runnerOnThird: Int @db(name: "runner_on_third")
  runsThisInningHalf: Int @db(name: "runs_this_inning_half")
  sequenceNumber: Int @db(name: "sequence_number")
  strikes: Int
}

type BaseballOffensiveStat @db(name: "baseball_offensive_stats") {
  atBats: Int @db(name: "at_bats")
  atBatsPerHomeRun: Float @db(name: "at_bats_per_home_run")
  atBatsPerRbi: Float @db(name: "at_bats_per_rbi")
  average: Float
  basesOnBalls: Int @db(name: "bases_on_balls")
  defensiveInterferanceReaches: Int @db(name: "defensive_interferance_reaches")
  doubles: Int
  grandSlams: Int @db(name: "grand_slams")
  groundedIntoDoublePlay: Int @db(name: "grounded_into_double_play")
  hitByPitch: Int @db(name: "hit_by_pitch")
  hits: Int
  hitsExtraBase: Int @db(name: "hits_extra_base")
  homeRuns: Int @db(name: "home_runs")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_offensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  leftInScoringPosition: Int @db(name: "left_in_scoring_position")
  leftOnBase: Int @db(name: "left_on_base")
  movedUp: Int @db(name: "moved_up")
  onBasePercentage: Float @db(name: "on_base_percentage")
  onBasePlusSlugging: Float @db(name: "on_base_plus_slugging")
  plateAppearances: Int @db(name: "plate_appearances")
  plateAppearancesPerHomeRun: Float @db(name: "plate_appearances_per_home_run")
  plateAppearancesPerRbi: Float @db(name: "plate_appearances_per_rbi")
  rbi: Int
  runsScored: Int @db(name: "runs_scored")
  sacBunts: Int @db(name: "sac_bunts")
  sacFlies: Int @db(name: "sac_flies")
  singles: Int
  sluggingPercentage: Float @db(name: "slugging_percentage")
  stolenBases: Int @db(name: "stolen_bases")
  stolenBasesAverage: Float @db(name: "stolen_bases_average")
  stolenBasesCaught: Int @db(name: "stolen_bases_caught")
  strikeouts: Int
  totalBases: Int @db(name: "total_bases")
  triples: Int
}

type BaseballPitchingStat @db(name: "baseball_pitching_stats") {
  balks: Int
  basesOnBalls: Int @db(name: "bases_on_balls")
  basesOnBallsIntentional: Int @db(name: "bases_on_balls_intentional")
  doublesAllowed: Int @db(name: "doubles_allowed")
  earnedRuns: Int @db(name: "earned_runs")
  era: Float
  errorsHitWithPitch: Int @db(name: "errors_hit_with_pitch")
  errorsWildPitch: Int @db(name: "errors_wild_pitch")
  eventCredit: String @db(name: "event_credit")
  gamesComplete: Int @db(name: "games_complete")
  gamesFinished: Int @db(name: "games_finished")
  hits: Int
  homeRunsAllowed: Int @db(name: "home_runs_allowed")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "baseball_pitching_stats_id_seq", initialValue: 1, allocationSize: 1)
  inheritedRunnersScored: Int @db(name: "inherited_runners_scored")
  inningsPitched: String @db(name: "innings_pitched")
  losses: Int
  numberOfPitches: Int @db(name: "number_of_pitches")
  pickOffs: Int @db(name: "pick_offs")
  runsAllowed: Int @db(name: "runs_allowed")
  saveCredit: String @db(name: "save_credit")
  saves: Int
  shutouts: Int
  singlesAllowed: Int @db(name: "singles_allowed")
  strikeouts: Int
  strikeoutToBbRatio: Float @db(name: "strikeout_to_bb_ratio")
  triplesAllowed: Int @db(name: "triples_allowed")
  unearnedRuns: Int @db(name: "unearned_runs")
  winningPercentage: Float @db(name: "winning_percentage")
  wins: Int
}

type BasketballDefensiveStat @db(name: "basketball_defensive_stats") {
  blocksPerGame: String @db(name: "blocks_per_game")
  blocksTotal: String @db(name: "blocks_total")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "basketball_defensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  stealsPerGame: String @db(name: "steals_per_game")
  stealsTotal: String @db(name: "steals_total")
}

type BasketballEventState @db(name: "basketball_event_states") {
  context: String
  currentState: Int @db(name: "current_state")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "basketball_event_states_id_seq", initialValue: 1, allocationSize: 1)
  periodTimeElapsed: String @db(name: "period_time_elapsed")
  periodTimeRemaining: String @db(name: "period_time_remaining")
  periodValue: String @db(name: "period_value")
  sequenceNumber: Int @db(name: "sequence_number")
}

type BasketballOffensiveStat @db(name: "basketball_offensive_stats") {
  assistsPerGame: String @db(name: "assists_per_game")
  assistsTotal: String @db(name: "assists_total")
  fieldGoalsAttempted: Int @db(name: "field_goals_attempted")
  fieldGoalsAttemptedPerGame: String @db(name: "field_goals_attempted_per_game")
  fieldGoalsMade: Int @db(name: "field_goals_made")
  fieldGoalsPercentage: String @db(name: "field_goals_percentage")
  fieldGoalsPercentageAdjusted: String @db(name: "field_goals_percentage_adjusted")
  fieldGoalsPerGame: String @db(name: "field_goals_per_game")
  freeThrowsAttempted: String @db(name: "free_throws_attempted")
  freeThrowsAttemptedPerGame: String @db(name: "free_throws_attempted_per_game")
  freeThrowsMade: String @db(name: "free_throws_made")
  freeThrowsPercentage: String @db(name: "free_throws_percentage")
  freeThrowsPerGame: String @db(name: "free_throws_per_game")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "basketball_offensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  pointsScoredInPaint: String @db(name: "points_scored_in_paint")
  pointsScoredOffTurnovers: String @db(name: "points_scored_off_turnovers")
  pointsScoredOnFastBreak: String @db(name: "points_scored_on_fast_break")
  pointsScoredOnSecondChance: String @db(name: "points_scored_on_second_chance")
  pointsScoredPerGame: String @db(name: "points_scored_per_game")
  pointsScoredTotal: String @db(name: "points_scored_total")
  threePointersAttempted: Int @db(name: "three_pointers_attempted")
  threePointersAttemptedPerGame: String @db(name: "three_pointers_attempted_per_game")
  threePointersMade: Int @db(name: "three_pointers_made")
  threePointersPercentage: String @db(name: "three_pointers_percentage")
  threePointersPerGame: String @db(name: "three_pointers_per_game")
  turnoversPerGame: String @db(name: "turnovers_per_game")
  turnoversTotal: String @db(name: "turnovers_total")
}

type BasketballReboundingStat @db(name: "basketball_rebounding_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "basketball_rebounding_stats_id_seq", initialValue: 1, allocationSize: 1)
  reboundsDefensive: String @db(name: "rebounds_defensive")
  reboundsOffensive: String @db(name: "rebounds_offensive")
  reboundsPerGame: String @db(name: "rebounds_per_game")
  reboundsTotal: String @db(name: "rebounds_total")
  teamReboundsDefensive: String @db(name: "team_rebounds_defensive")
  teamReboundsOffensive: String @db(name: "team_rebounds_offensive")
  teamReboundsPerGame: String @db(name: "team_rebounds_per_game")
  teamReboundsTotal: String @db(name: "team_rebounds_total")
}

type BasketballTeamStat @db(name: "basketball_team_stats") {
  foulsTotal: String @db(name: "fouls_total")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "basketball_team_stats_id_seq", initialValue: 1, allocationSize: 1)
  largestLead: String @db(name: "largest_lead")
  timeoutsLeft: String @db(name: "timeouts_left")
  turnoverMargin: String @db(name: "turnover_margin")
}

type Bookmaker @db(name: "bookmakers") {
  bookmakerKey: String @db(name: "bookmaker_key")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "bookmakers_id_seq", initialValue: 1, allocationSize: 1)
  location: Location @db(name: "location_id")
  publisher: Publisher! @db(name: "publisher_id")
  wageringMoneylines: [WageringMoneyline]
  wageringOddsLines: [WageringOddsLine]
  wageringRunlines: [WageringRunline]
  wageringStraightSpreadLines: [WageringStraightSpreadLine]
  wageringTotalScoreLines: [WageringTotalScoreLine]
}

type CorePersonStat @db(name: "core_person_stats") {
  eventsPlayed: Int @db(name: "events_played")
  eventsStarted: Int @db(name: "events_started")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "core_person_stats_id_seq", initialValue: 1, allocationSize: 1)
  position: Position @db(name: "position_id")
  timePlayedEvent: String @db(name: "time_played_event")
  timePlayedEventAverage: String @db(name: "time_played_event_average")
  timePlayedTotal: String @db(name: "time_played_total")
}

type CoreStat @db(name: "core_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "core_stats_id_seq", initialValue: 1, allocationSize: 1)
  score: String
  scoreAttempts: String @db(name: "score_attempts")
  scoreAttemptsOpposing: String @db(name: "score_attempts_opposing")
  scoreOpposing: String @db(name: "score_opposing")
  scorePercentage: String @db(name: "score_percentage")
  scorePercentageOpposing: String @db(name: "score_percentage_opposing")
}

type DbInfo @db(name: "db_info") {
  version: String! @default(value: "16")
}

type DisplayName @db(name: "display_names") {
  abbreviation: String
  alias: String
  entityId: Int! @db(name: "entity_id")
  entityType: String! @db(name: "entity_type")
  firstName: String @db(name: "first_name")
  fullName: String @db(name: "full_name")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "display_names_id_seq", initialValue: 1, allocationSize: 1)
  language: String!
  lastName: String @db(name: "last_name")
  middleName: String @db(name: "middle_name")
  prefix: String
  shortName: String @db(name: "short_name")
  suffix: String
}

type Document @db(name: "documents") {
  affiliationsDocuments: [AffiliationsDocument]
  dateTime: DateTime @db(name: "date_time")
  dbLoadingDateTime: DateTime @db(name: "db_loading_date_time")
  docId: String! @db(name: "doc_id")
  documentContents: [DocumentContent]
  documentFixture: DocumentFixture! @db(name: "document_fixture_id")
  documentFixturesEvents: [DocumentFixturesEvent]
  documentPackageEntry: [DocumentPackageEntry]
  documentsMedia: [DocumentsMedia]
  eventsDocuments: [EventsDocument]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "documents_id_seq", initialValue: 1, allocationSize: 1)
  language: String
  latestRevisions: [LatestRevision]
  personsDocuments: [PersonsDocument]
  priority: String
  publisher: Publisher! @db(name: "publisher_id") @relation(name: "DocumentPublisherToPublisherDocuments")
  revisionId: String @db(name: "revision_id")
  source: Publisher @db(name: "source_id") @relation(name: "DocumentSourceToPublisherDocuments")
  statsCoverage: String @db(name: "stats_coverage")
  teamsDocuments: [TeamsDocument]
  title: String
}

type DocumentClass @db(name: "document_classes") {
  documentFixtures: [DocumentFixture]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "document_classes_id_seq", initialValue: 1, allocationSize: 1)
  name: String
}

type DocumentContent @db(name: "document_contents") {
  abstract: String
  document: Document! @db(name: "document_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "document_contents_id_seq", initialValue: 1, allocationSize: 1)
  sportsml: String
}

type DocumentFixture @db(name: "document_fixtures") {
  documentClass: DocumentClass! @db(name: "document_class_id")
  documentFixturesEvents: [DocumentFixturesEvent]
  documents: [Document]
  fixtureKey: String @db(name: "fixture_key")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "document_fixtures_id_seq", initialValue: 1, allocationSize: 1)
  name: String
  publisher: Publisher! @db(name: "publisher_id")
}

type DocumentFixturesEvent @db(name: "document_fixtures_events") {
  documentFixture: DocumentFixture! @db(name: "document_fixture_id")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "document_fixtures_events_id_seq", initialValue: 1, allocationSize: 1)
  lastUpdate: DateTime @db(name: "last_update")
  latestDocument: Document! @db(name: "latest_document_id")
}

type DocumentPackage @db(name: "document_packages") {
  dateTime: DateTime @db(name: "date_time")
  documentPackageEntry: [DocumentPackageEntry]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "document_packages_id_seq", initialValue: 1, allocationSize: 1)
  packageKey: String @db(name: "package_key")
  packageName: String @db(name: "package_name")
}

type DocumentPackageEntry @db(name: "document_package_entry") {
  document: Document! @db(name: "document_id")
  documentPackage: DocumentPackage! @db(name: "document_package_id")
  headline: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "document_package_entry_id_seq", initialValue: 1, allocationSize: 1)
  rank: String
  shortHeadline: String @db(name: "short_headline")
}

type DocumentsMedia @db(name: "documents_media") {
  document: Document! @db(name: "document_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "documents_media_id_seq", initialValue: 1, allocationSize: 1)
  media: Media! @db(name: "media_id")
  mediaCaption: MediaCaption! @db(name: "media_caption_id")
}

type Event @db(name: "events") {
  affiliationsEvents: [AffiliationsEvent]
  americanFootballEventStates: [AmericanFootballEventState]
  attendance: String
  baseballEventStates: [BaseballEventState]
  basketballEventStates: [BasketballEventState]
  documentFixturesEvents: [DocumentFixturesEvent]
  duration: String
  eventKey: String! @db(name: "event_key")
  eventsDocuments: [EventsDocument]
  eventsMedia: [EventsMedia]
  eventsSubSeasons: [EventsSubSeason]
  eventStatus: String @db(name: "event_status")
  iceHockeyEventStates: [IceHockeyEventState]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "events_id_seq", initialValue: 1, allocationSize: 1)
  lastUpdate: DateTime @db(name: "last_update")
  motorRacingEventStates: [MotorRacingEventState]
  participantsEvents: [ParticipantsEvent]
  personEventMetadata: [PersonEventMetadatum]
  publisher: Publisher! @db(name: "publisher_id")
  site: Site @db(name: "site_id")
  siteAlignment: String @db(name: "site_alignment")
  soccerEventStates: [SoccerEventState]
  startDateTime: DateTime @db(name: "start_date_time")
  tennisEventStates: [TennisEventState]
  wageringMoneylines: [WageringMoneyline]
  wageringOddsLines: [WageringOddsLine]
  wageringRunlines: [WageringRunline]
  wageringStraightSpreadLines: [WageringStraightSpreadLine]
  wageringTotalScoreLines: [WageringTotalScoreLine]
  weatherConditions: [WeatherCondition]
}

type EventsDocument @db(name: "events_documents") @linkTable {
  document: Document! @db(name: "document_id")
  event: Event! @db(name: "event_id")
}

type EventsMedia @db(name: "events_media") @linkTable {
  event: Event! @db(name: "event_id")
  media: Media! @db(name: "media_id")
}

type EventsSubSeason @db(name: "events_sub_seasons") @linkTable {
  event: Event! @db(name: "event_id")
  subSeason: SubSeason! @db(name: "sub_season_id")
}

type IceHockeyActionParticipant @db(name: "ice_hockey_action_participants") {
  iceHockeyActionPlayId: Int! @db(name: "ice_hockey_action_play_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "ice_hockey_action_participants_id_seq", initialValue: 1, allocationSize: 1)
  participantRole: String! @db(name: "participant_role")
  personId: Int! @db(name: "person_id")
  pointCredit: Int @db(name: "point_credit")
}

type IceHockeyActionPlay @db(name: "ice_hockey_action_plays") {
  comment: String
  iceHockeyEventStateId: Int! @db(name: "ice_hockey_event_state_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "ice_hockey_action_plays_id_seq", initialValue: 1, allocationSize: 1)
  playResult: String @db(name: "play_result")
  playType: String @db(name: "play_type")
  scoreAttemptType: String @db(name: "score_attempt_type")
}

type IceHockeyDefensiveStat @db(name: "ice_hockey_defensive_stats") {
  goalsAgainstAverage: String @db(name: "goals_against_average")
  goalsEmptyNetAllowed: String @db(name: "goals_empty_net_allowed")
  goalsPenaltyShotAllowed: String @db(name: "goals_penalty_shot_allowed")
  goalsPowerPlayAllowed: String @db(name: "goals_power_play_allowed")
  goalsShootoutAllowed: String @db(name: "goals_shootout_allowed")
  goalsShortHandedAllowed: String @db(name: "goals_short_handed_allowed")
  hits: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "ice_hockey_defensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  minutesPenaltyKilling: String @db(name: "minutes_penalty_killing")
  penaltyKillingAmount: String @db(name: "penalty_killing_amount")
  penaltyKillingPercentage: String @db(name: "penalty_killing_percentage")
  savePercentage: String @db(name: "save_percentage")
  saves: String
  shotsBlocked: String @db(name: "shots_blocked")
  shotsPenaltyShotAllowed: String @db(name: "shots_penalty_shot_allowed")
  shotsPowerPlayAllowed: String @db(name: "shots_power_play_allowed")
  shotsShootoutAllowed: String @db(name: "shots_shootout_allowed")
  shutouts: String
  takeaways: String
}

type IceHockeyEventState @db(name: "ice_hockey_event_states") {
  context: String
  currentState: Int @db(name: "current_state")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "ice_hockey_event_states_id_seq", initialValue: 1, allocationSize: 1)
  periodTimeElapsed: String @db(name: "period_time_elapsed")
  periodTimeRemaining: String @db(name: "period_time_remaining")
  periodValue: String @db(name: "period_value")
  sequenceNumber: Int @db(name: "sequence_number")
}

type IceHockeyOffensiveStat @db(name: "ice_hockey_offensive_stats") {
  assists: String
  faceoffLosses: String @db(name: "faceoff_losses")
  faceoffWinPercentage: String @db(name: "faceoff_win_percentage")
  faceoffWins: String @db(name: "faceoff_wins")
  giveaways: String
  goalsEmptyNet: String @db(name: "goals_empty_net")
  goalsEvenStrength: String @db(name: "goals_even_strength")
  goalsGameTying: String @db(name: "goals_game_tying")
  goalsGameWinning: String @db(name: "goals_game_winning")
  goalsOvertime: String @db(name: "goals_overtime")
  goalsPenaltyShot: String @db(name: "goals_penalty_shot")
  goalsPowerPlay: String @db(name: "goals_power_play")
  goalsShootout: String @db(name: "goals_shootout")
  goalsShortHanded: String @db(name: "goals_short_handed")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "ice_hockey_offensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  minutesPowerPlay: String @db(name: "minutes_power_play")
  points: String
  powerPlayAmount: String @db(name: "power_play_amount")
  powerPlayPercentage: String @db(name: "power_play_percentage")
  scoringChances: String @db(name: "scoring_chances")
  shotsPenaltyShotMissed: String @db(name: "shots_penalty_shot_missed")
  shotsPenaltyShotPercentage: String @db(name: "shots_penalty_shot_percentage")
  shotsPenaltyShotTaken: String @db(name: "shots_penalty_shot_taken")
}

type IceHockeyPlayerStat @db(name: "ice_hockey_player_stats") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "ice_hockey_player_stats_id_seq", initialValue: 1, allocationSize: 1)
  plusMinus: String @db(name: "plus_minus")
}

type InjuryPhase @db(name: "injury_phases") {
  disabledList: String @db(name: "disabled_list")
  endDateTime: DateTime @db(name: "end_date_time")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "injury_phases_id_seq", initialValue: 1, allocationSize: 1)
  injuryComment: String @db(name: "injury_comment")
  injurySide: String @db(name: "injury_side")
  injuryStatus: String @db(name: "injury_status")
  injuryType: String @db(name: "injury_type")
  person: Person! @db(name: "person_id")
  phaseType: String @db(name: "phase_type")
  season: Season @db(name: "season_id")
  startDateTime: DateTime @db(name: "start_date_time")
}

type KeyAlias @db(name: "key_aliases") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "key_aliases_id_seq", initialValue: 1, allocationSize: 1)
  keyId: Int! @db(name: "key_id")
  keyRoot: KeyRoot! @db(name: "key_root_id")
}

type KeyRoot @db(name: "key_roots") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "key_roots_id_seq", initialValue: 1, allocationSize: 1)
  keyAliases: [KeyAlias]
  keyType: String @db(name: "key_type")
}

type LatestRevision @db(name: "latest_revisions") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "latest_revisions_id_seq", initialValue: 1, allocationSize: 1)
  latestDocument: Document! @db(name: "latest_document_id")
  revisionId: String! @db(name: "revision_id")
}

type Location @db(name: "locations") {
  addresses: [Address]
  bookmakers: [Bookmaker]
  countryCode: String @db(name: "country_code")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "locations_id_seq", initialValue: 1, allocationSize: 1)
  latitude: String
  longitude: String
  media: [Media]
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references Person.residenceLocation.
  # persons: [Person] @relation(name: "LocationPersonsToPersonResidenceLocation")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references Person.hometownLocation.
  # persons: [Person] @relation(name: "LocationPersonsToPersonHometownLocation")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references Person.deathLocation.
  # persons: [Person] @relation(name: "LocationPersonsToPersonDeathLocation")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references Person.birthLocation.
  # persons: [Person] @relation(name: "LocationPersonsToPersonBirthLocation")
  sites: [Site]
  timezone: String
}

type Media @db(name: "media") {
  affiliationsMedia: [AffiliationsMedia]
  creationLocation: Location! @db(name: "creation_location_id")
  credit: Person! @db(name: "credit_id")
  dateTime: String @db(name: "date_time")
  dbLoadingDateTime: DateTime @db(name: "db_loading_date_time")
  documentsMedia: [DocumentsMedia]
  eventsMedia: [EventsMedia]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "media_id_seq", initialValue: 1, allocationSize: 1)
  mediaCaptions: [MediaCaption]
  mediaContents: [MediaContent]
  mediaKeywords: [MediaKeyword]
  mediaType: String @db(name: "media_type")
  objectId: Int @db(name: "object_id")
  personsMedia: [PersonsMedia]
  publisher: Publisher! @db(name: "publisher_id")
  revisionId: Int @db(name: "revision_id")
  sourceId: Int @db(name: "source_id")
  teamsMedia: [TeamsMedia]
}

type MediaCaption @db(name: "media_captions") {
  caption: String
  captionAuthor: Person! @db(name: "caption_author_id")
  captionSize: String @db(name: "caption_size")
  captionType: String @db(name: "caption_type")
  documentsMedia: [DocumentsMedia]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "media_captions_id_seq", initialValue: 1, allocationSize: 1)
  language: String
  media: Media! @db(name: "media_id")
}

type MediaContent @db(name: "media_contents") {
  duration: String
  fileSize: String @db(name: "file_size")
  format: String
  height: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "media_contents_id_seq", initialValue: 1, allocationSize: 1)
  media: Media! @db(name: "media_id")
  mimeType: String @db(name: "mime_type")
  object: String
  resolution: String
  width: String
}

type MediaKeyword @db(name: "media_keywords") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "media_keywords_id_seq", initialValue: 1, allocationSize: 1)
  keyword: String
  media: Media! @db(name: "media_id")
}

type MotorRacingEventState @db(name: "motor_racing_event_states") {
  context: String
  currentState: Int @db(name: "current_state")
  event: Event! @db(name: "event_id")
  flagState: String @db(name: "flag_state")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "motor_racing_event_states_id_seq", initialValue: 1, allocationSize: 1)
  lap: String
  lapsRemaining: String @db(name: "laps_remaining")
  sequenceNumber: Int @db(name: "sequence_number")
  timeElapsed: String @db(name: "time_elapsed")
}

type MotorRacingQualifyingStat @db(name: "motor_racing_qualifying_stats") {
  grid: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "motor_racing_qualifying_stats_id_seq", initialValue: 1, allocationSize: 1)
  polePosition: String @db(name: "pole_position")
  poleWins: String @db(name: "pole_wins")
  qualifyingPosition: String @db(name: "qualifying_position")
  qualifyingSpeed: String @db(name: "qualifying_speed")
  qualifyingSpeedUnits: String @db(name: "qualifying_speed_units")
  qualifyingTime: String @db(name: "qualifying_time")
}

type MotorRacingRaceStat @db(name: "motor_racing_race_stats") {
  bonus: String
  distanceCompleted: String @db(name: "distance_completed")
  distanceLeading: String @db(name: "distance_leading")
  distanceUnits: String @db(name: "distance_units")
  finishes: String
  finishesTop10: String @db(name: "finishes_top_10")
  finishesTop5: String @db(name: "finishes_top_5")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "motor_racing_race_stats_id_seq", initialValue: 1, allocationSize: 1)
  lapsAheadFollower: String @db(name: "laps_ahead_follower")
  lapsBehindLeader: String @db(name: "laps_behind_leader")
  lapsCompleted: String @db(name: "laps_completed")
  lapsLeadingTotal: String @db(name: "laps_leading_total")
  leadsTotal: String @db(name: "leads_total")
  money: String
  moneyUnits: String @db(name: "money_units")
  nonFinishes: String @db(name: "non_finishes")
  points: String
  pointsRookie: String @db(name: "points_rookie")
  racesLeading: String @db(name: "races_leading")
  speedAverage: String @db(name: "speed_average")
  speedUnits: String @db(name: "speed_units")
  starts: String
  status: String
  time: String
  timeAheadFollower: String @db(name: "time_ahead_follower")
  timeBehindLeader: String @db(name: "time_behind_leader")
  wins: String
}

type OutcomeTotal @db(name: "outcome_totals") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "outcome_totals_id_seq", initialValue: 1, allocationSize: 1)
  losses: String
  outcomeHolderId: Int @db(name: "outcome_holder_id")
  outcomeHolderType: String @db(name: "outcome_holder_type")
  pointsDifference: String @db(name: "points_difference")
  pointsScoredAgainst: String @db(name: "points_scored_against")
  pointsScoredFor: String @db(name: "points_scored_for")
  rank: String
  standingPoints: String @db(name: "standing_points")
  standingSubgroup: StandingSubgroup! @db(name: "standing_subgroup_id")
  streakDuration: String @db(name: "streak_duration")
  streakEnd: DateTime @db(name: "streak_end")
  streakStart: DateTime @db(name: "streak_start")
  streakTotal: String @db(name: "streak_total")
  streakType: String @db(name: "streak_type")
  ties: String
  undecideds: String
  winningPercentage: String @db(name: "winning_percentage")
  wins: String
}

type ParticipantsEvent @db(name: "participants_events") {
  alignment: String
  event: Event! @db(name: "event_id")
  eventOutcome: String @db(name: "event_outcome")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "participants_events_id_seq", initialValue: 1, allocationSize: 1)
  participantId: Int! @db(name: "participant_id")
  participantType: String! @db(name: "participant_type")
  periods: [Period]
  rank: Int
  score: String
}

type Period @db(name: "periods") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "periods_id_seq", initialValue: 1, allocationSize: 1)
  participantEvent: ParticipantsEvent! @db(name: "participant_event_id")
  periodValue: String @db(name: "period_value")
  score: String
  subPeriods: [SubPeriod]
}

type Person @db(name: "persons") {
  americanFootballActionParticipants: [AmericanFootballActionParticipant]
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references BaseballActionSubstitution.personReplacing.
  # baseballActionSubstitutions: [BaseballActionSubstitution] @relation(name: "BaseballActionSubstitutionPersonReplacingToPersonBaseballActionSubstitutions")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references BaseballActionSubstitution.personOriginal.
  # baseballActionSubstitutions: [BaseballActionSubstitution] @relation(name: "BaseballActionSubstitutionPersonOriginalToPersonBaseballActionSubstitutions")
  baseballDefensivePlayers: [BaseballDefensivePlayer]
  # Field name normalization failed because of a conflicting field name.
  baseballEventStates: [BaseballEventState] @relation(name: "BaseballEventStateRunner_on_third_idToPersonBaseballEventStates")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references BaseballEventState.runner_on_second_id.
  # baseballEventStates: [BaseballEventState] @relation(name: "BaseballEventStateRunner_on_second_idToPersonBaseballEventStates")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references BaseballEventState.runner_on_first_id.
  # baseballEventStates: [BaseballEventState] @relation(name: "BaseballEventStateRunner_on_first_idToPersonBaseballEventStates")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references BaseballEventState.pitcher.
  # baseballEventStates: [BaseballEventState] @relation(name: "BaseballEventStatePitcherToPersonBaseballEventStates")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references BaseballEventState.batter.
  # baseballEventStates: [BaseballEventState] @relation(name: "BaseballEventStateBatterToPersonBaseballEventStates")
  birthDate: String @db(name: "birth_date")
  birthLocation: Location @db(name: "birth_location_id") @relation(name: "LocationPersonsToPersonBirthLocation")
  deathDate: String @db(name: "death_date")
  deathLocation: Location @db(name: "death_location_id") @relation(name: "LocationPersonsToPersonDeathLocation")
  gender: String
  hometownLocation: Location @db(name: "hometown_location_id") @relation(name: "LocationPersonsToPersonHometownLocation")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "persons_id_seq", initialValue: 1, allocationSize: 1)
  injuryPhases: [InjuryPhase]
  media: [Media]
  mediaCaptions: [MediaCaption]
  personEventMetadata: [PersonEventMetadatum]
  personKey: String! @db(name: "person_key")
  personPhases: [PersonPhase]
  personsDocuments: [PersonsDocument]
  personsMedia: [PersonsMedia]
  publisher: Publisher! @db(name: "publisher_id")
  residenceLocation: Location @db(name: "residence_location_id") @relation(name: "LocationPersonsToPersonResidenceLocation")
}

type PersonEventMetadatum @db(name: "person_event_metadata") {
  event: Event! @db(name: "event_id")
  health: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "person_event_metadata_id_seq", initialValue: 1, allocationSize: 1)
  lineupSlot: Int @db(name: "lineup_slot")
  lineupSlotSequence: Int @db(name: "lineup_slot_sequence")
  person: Person! @db(name: "person_id")
  position: Position @db(name: "position_id")
  role: Role @db(name: "role_id")
  status: String
  team: Team @db(name: "team_id")
  weight: String
}

type PersonPhase @db(name: "person_phases") {
  endDateTime: DateTime @db(name: "end_date_time")
  endSeason: Season @db(name: "end_season_id") @relation(name: "PersonPhaseEndSeasonToSeasonPersonPhases")
  entryReason: String @db(name: "entry_reason")
  exitReason: String @db(name: "exit_reason")
  height: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "person_phases_id_seq", initialValue: 1, allocationSize: 1)
  membershipId: Int! @db(name: "membership_id")
  membershipType: String! @db(name: "membership_type")
  person: Person! @db(name: "person_id")
  phaseStatus: String @db(name: "phase_status")
  regularPosition: Position @db(name: "regular_position_id")
  regularPositionDepth: String @db(name: "regular_position_depth")
  role: Role @db(name: "role_id")
  roleStatus: String @db(name: "role_status")
  selectionLevel: Int @db(name: "selection_level")
  selectionOverall: Int @db(name: "selection_overall")
  selectionSublevel: Int @db(name: "selection_sublevel")
  startDateTime: DateTime @db(name: "start_date_time")
  startSeason: Season @db(name: "start_season_id") @relation(name: "PersonPhaseStartSeasonToSeasonPersonPhases")
  uniformNumber: String @db(name: "uniform_number")
  weight: String
}

type PersonsDocument @db(name: "persons_documents") @linkTable {
  document: Document! @db(name: "document_id")
  person: Person! @db(name: "person_id")
}

type PersonsMedia @db(name: "persons_media") @linkTable {
  media: Media! @db(name: "media_id")
  person: Person! @db(name: "person_id")
}

type Position @db(name: "positions") {
  abbreviation: String!
  affiliation: Affiliation! @db(name: "affiliation_id")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references BaseballActionSubstitution.personReplacingPosition.
  # baseballActionSubstitutions: [BaseballActionSubstitution] @relation(name: "BaseballActionSubstitutionPersonReplacingPositionToPositionBaseballActionSubstitutions")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references BaseballActionSubstitution.personOriginalPosition.
  # baseballActionSubstitutions: [BaseballActionSubstitution] @relation(name: "BaseballActionSubstitutionPersonOriginalPositionToPositionBaseballActionSubstitutions")
  baseballDefensivePlayers: [BaseballDefensivePlayer]
  corePersonStats: [CorePersonStat]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "positions_id_seq", initialValue: 1, allocationSize: 1)
  personEventMetadata: [PersonEventMetadatum]
  personPhases: [PersonPhase]
}

type Publisher @db(name: "publishers") {
  affiliations: [Affiliation]
  bookmakers: [Bookmaker]
  documentFixtures: [DocumentFixture]
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references Document.source.
  # documents: [Document] @relation(name: "DocumentSourceToPublisherDocuments")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references Document.publisher.
  # documents: [Document] @relation(name: "DocumentPublisherToPublisherDocuments")
  events: [Event]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "publishers_id_seq", initialValue: 1, allocationSize: 1)
  media: [Media]
  persons: [Person]
  publisherKey: String! @db(name: "publisher_key")
  publisherName: String @db(name: "publisher_name")
  seasons: [Season]
  sites: [Site]
  standings: [Standing]
  teams: [Team]
}

type Role @db(name: "roles") {
  comment: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "roles_id_seq", initialValue: 1, allocationSize: 1)
  personEventMetadata: [PersonEventMetadatum]
  personPhases: [PersonPhase]
  roleKey: String! @db(name: "role_key")
  roleName: String @db(name: "role_name")
  teamPhases: [TeamPhase]
}

type Season @db(name: "seasons") {
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references AffiliationPhase.startSeason.
  # affiliationPhases: [AffiliationPhase] @relation(name: "AffiliationPhaseStartSeasonToSeasonAffiliationPhases")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references AffiliationPhase.endSeason.
  # affiliationPhases: [AffiliationPhase] @relation(name: "AffiliationPhaseEndSeasonToSeasonAffiliationPhases")
  endDateTime: DateTime @db(name: "end_date_time")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "seasons_id_seq", initialValue: 1, allocationSize: 1)
  injuryPhases: [InjuryPhase]
  league: Affiliation! @db(name: "league_id")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references PersonPhase.startSeason.
  # personPhases: [PersonPhase] @relation(name: "PersonPhaseStartSeasonToSeasonPersonPhases")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references PersonPhase.endSeason.
  # personPhases: [PersonPhase] @relation(name: "PersonPhaseEndSeasonToSeasonPersonPhases")
  publisher: Publisher! @db(name: "publisher_id")
  seasonKey: Int! @db(name: "season_key")
  startDateTime: DateTime @db(name: "start_date_time")
  subSeasons: [SubSeason]
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references TeamPhase.startSeason.
  # teamPhases: [TeamPhase] @relation(name: "SeasonTeamPhasesToTeamPhaseStartSeason")
  # Field name normalization failed because of a conflicting field name.
  # Could not auto-generate backwards relation field, field name would be ambiguous.
  # Please specify the name of this field and the name of the relation manually.
  # It references TeamPhase.endSeason.
  # teamPhases: [TeamPhase] @relation(name: "SeasonTeamPhasesToTeamPhaseEndSeason")
}

type Site @db(name: "sites") {
  events: [Event]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "sites_id_seq", initialValue: 1, allocationSize: 1)
  location: Location @db(name: "location_id")
  publisher: Publisher! @db(name: "publisher_id")
  siteKey: Int! @db(name: "site_key")
  teams: [Team]
}

type SoccerDefensiveStat @db(name: "soccer_defensive_stats") {
  catchesPunches: String @db(name: "catches_punches")
  goalsAgainstAverage: String @db(name: "goals_against_average")
  goalsAgainstTotal: String @db(name: "goals_against_total")
  goalsPenaltyShotAllowed: String @db(name: "goals_penalty_shot_allowed")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "soccer_defensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  savePercentage: String @db(name: "save_percentage")
  saves: String
  shotsBlocked: String @db(name: "shots_blocked")
  shotsOnGoalTotal: String @db(name: "shots_on_goal_total")
  shotsPenaltyShotAllowed: String @db(name: "shots_penalty_shot_allowed")
  shotsShootoutAllowed: String @db(name: "shots_shootout_allowed")
  shotsShootoutTotal: String @db(name: "shots_shootout_total")
  shutouts: String
}

type SoccerEventState @db(name: "soccer_event_states") {
  context: String
  currentState: Int @db(name: "current_state")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "soccer_event_states_id_seq", initialValue: 1, allocationSize: 1)
  minutesElapsed: String @db(name: "minutes_elapsed")
  periodMinuteElapsed: String @db(name: "period_minute_elapsed")
  periodTimeElapsed: String @db(name: "period_time_elapsed")
  periodTimeRemaining: String @db(name: "period_time_remaining")
  periodValue: String @db(name: "period_value")
  sequenceNumber: Int @db(name: "sequence_number")
}

type SoccerFoulStat @db(name: "soccer_foul_stats") {
  cautionPointsPending: String @db(name: "caution_points_pending")
  cautionPointsTotal: String @db(name: "caution_points_total")
  cautionsPending: String @db(name: "cautions_pending")
  cautionsTotal: String @db(name: "cautions_total")
  ejectionsTotal: String @db(name: "ejections_total")
  foulsCommited: String @db(name: "fouls_commited")
  foulsSuffered: String @db(name: "fouls_suffered")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "soccer_foul_stats_id_seq", initialValue: 1, allocationSize: 1)
}

type SoccerOffensiveStat @db(name: "soccer_offensive_stats") {
  assistsGameTying: String @db(name: "assists_game_tying")
  assistsGameWinning: String @db(name: "assists_game_winning")
  assistsOvertime: String @db(name: "assists_overtime")
  assistsTotal: String @db(name: "assists_total")
  cornerKicks: String @db(name: "corner_kicks")
  giveaways: String
  goalsGameTying: String @db(name: "goals_game_tying")
  goalsGameWinning: String @db(name: "goals_game_winning")
  goalsOvertime: String @db(name: "goals_overtime")
  goalsShootout: String @db(name: "goals_shootout")
  goalsTotal: String @db(name: "goals_total")
  hatTricks: String @db(name: "hat_tricks")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "soccer_offensive_stats_id_seq", initialValue: 1, allocationSize: 1)
  offsides: String
  points: String
  shotsHitFrame: String @db(name: "shots_hit_frame")
  shotsOnGoalTotal: String @db(name: "shots_on_goal_total")
  shotsPenaltyShotMissed: String @db(name: "shots_penalty_shot_missed")
  shotsPenaltyShotPercentage: String @db(name: "shots_penalty_shot_percentage")
  shotsPenaltyShotScored: String @db(name: "shots_penalty_shot_scored")
  shotsPenaltyShotTaken: String @db(name: "shots_penalty_shot_taken")
  shotsShootoutMissed: String @db(name: "shots_shootout_missed")
  shotsShootoutPercentage: String @db(name: "shots_shootout_percentage")
  shotsShootoutScored: String @db(name: "shots_shootout_scored")
  shotsShootoutTaken: String @db(name: "shots_shootout_taken")
  shotsTotal: String @db(name: "shots_total")
}

type Standing @db(name: "standings") {
  affiliation: Affiliation! @db(name: "affiliation_id")
  alignmentScope: String @db(name: "alignment_scope")
  competitionScope: String @db(name: "competition_scope")
  competitionScopeId: String @db(name: "competition_scope_id")
  durationScope: String @db(name: "duration_scope")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "standings_id_seq", initialValue: 1, allocationSize: 1)
  lastUpdated: String @db(name: "last_updated")
  publisher: Publisher! @db(name: "publisher_id")
  scopingLabel: String @db(name: "scoping_label")
  siteScope: String @db(name: "site_scope")
  source: String
  standingSubgroups: [StandingSubgroup]
  standingType: String @db(name: "standing_type")
  subSeason: SubSeason! @db(name: "sub_season_id")
}

type StandingSubgroup @db(name: "standing_subgroups") {
  affiliation: Affiliation! @db(name: "affiliation_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "standing_subgroups_id_seq", initialValue: 1, allocationSize: 1)
  outcomeTotals: [OutcomeTotal]
  standing: Standing! @db(name: "standing_id")
}

type Stat @db(name: "stats") {
  context: String!
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "stats_id_seq", initialValue: 1, allocationSize: 1)
  statCoverageId: Int @db(name: "stat_coverage_id")
  statCoverageType: String @db(name: "stat_coverage_type")
  statHolderId: Int @db(name: "stat_holder_id")
  statHolderType: String @db(name: "stat_holder_type")
  statRepositoryId: Int! @db(name: "stat_repository_id")
  statRepositoryType: String @db(name: "stat_repository_type")
}

type SubPeriod @db(name: "sub_periods") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "sub_periods_id_seq", initialValue: 1, allocationSize: 1)
  period: Period! @db(name: "period_id")
  score: String
  subPeriodValue: String @db(name: "sub_period_value")
}

type SubSeason @db(name: "sub_seasons") {
  endDateTime: DateTime @db(name: "end_date_time")
  eventsSubSeasons: [EventsSubSeason]
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "sub_seasons_id_seq", initialValue: 1, allocationSize: 1)
  season: Season! @db(name: "season_id")
  standings: [Standing]
  startDateTime: DateTime @db(name: "start_date_time")
  subSeasonKey: String! @db(name: "sub_season_key")
  subSeasonType: String! @db(name: "sub_season_type")
}

type Team @db(name: "teams") {
  americanFootballEventStates: [AmericanFootballEventState]
  homeSite: Site @db(name: "home_site_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "teams_id_seq", initialValue: 1, allocationSize: 1)
  personEventMetadata: [PersonEventMetadatum]
  publisher: Publisher! @db(name: "publisher_id")
  teamKey: String! @db(name: "team_key")
  teamPhases: [TeamPhase]
  teamsDocuments: [TeamsDocument]
  teamsMedia: [TeamsMedia]
  wageringMoneylines: [WageringMoneyline]
  wageringOddsLines: [WageringOddsLine]
  wageringRunlines: [WageringRunline]
  wageringStraightSpreadLines: [WageringStraightSpreadLine]
  wageringTotalScoreLines: [WageringTotalScoreLine]
}

type TeamAmericanFootballStat @db(name: "team_american_football_stats") {
  averageStartingPosition: String @db(name: "average_starting_position")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "team_american_football_stats_id_seq", initialValue: 1, allocationSize: 1)
  timeOfPossession: String @db(name: "time_of_possession")
  timeouts: String
  turnoverRatio: String @db(name: "turnover_ratio")
  yardsPerAttempt: String @db(name: "yards_per_attempt")
}

type TeamPhase @db(name: "team_phases") {
  affiliation: Affiliation! @db(name: "affiliation_id")
  endDateTime: String @db(name: "end_date_time")
  endSeason: Season @db(name: "end_season_id") @relation(name: "SeasonTeamPhasesToTeamPhaseEndSeason")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "team_phases_id_seq", initialValue: 1, allocationSize: 1)
  phaseStatus: String @db(name: "phase_status")
  role: Role @db(name: "role_id")
  startDateTime: String @db(name: "start_date_time")
  startSeason: Season @db(name: "start_season_id") @relation(name: "SeasonTeamPhasesToTeamPhaseStartSeason")
  team: Team! @db(name: "team_id")
}

type TeamsDocument @db(name: "teams_documents") @linkTable {
  document: Document! @db(name: "document_id")
  team: Team! @db(name: "team_id")
}

type TeamsMedia @db(name: "teams_media") @linkTable {
  media: Media! @db(name: "media_id")
  team: Team! @db(name: "team_id")
}

type TennisActionPoint @db(name: "tennis_action_points") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tennis_action_points_id_seq", initialValue: 1, allocationSize: 1)
  sequenceNumber: String @db(name: "sequence_number")
  subPeriodId: String @db(name: "sub_period_id")
  winType: String @db(name: "win_type")
}

type TennisActionVolley @db(name: "tennis_action_volleys") {
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tennis_action_volleys_id_seq", initialValue: 1, allocationSize: 1)
  landingLocation: String @db(name: "landing_location")
  result: String
  sequenceNumber: String @db(name: "sequence_number")
  spinType: String @db(name: "spin_type")
  swingType: String @db(name: "swing_type")
  tennisActionPointsId: Int @db(name: "tennis_action_points_id")
  trajectoryDetails: String @db(name: "trajectory_details")
}

type TennisEventState @db(name: "tennis_event_states") {
  context: String
  currentState: Int @db(name: "current_state")
  event: Event! @db(name: "event_id")
  game: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tennis_event_states_id_seq", initialValue: 1, allocationSize: 1)
  receiverPersonId: Int @db(name: "receiver_person_id")
  receiverScore: String @db(name: "receiver_score")
  sequenceNumber: Int @db(name: "sequence_number")
  serverPersonId: Int @db(name: "server_person_id")
  serverScore: String @db(name: "server_score")
  serviceNumber: String @db(name: "service_number")
  tennisSet: String @db(name: "tennis_set")
}

type TennisReturnStat @db(name: "tennis_return_stats") {
  breakPointsConverted: String @db(name: "break_points_converted")
  breakPointsConvertedPct: String @db(name: "break_points_converted_pct")
  breakPointsPlayed: String @db(name: "break_points_played")
  firstServiceReturnPointsWon: String @db(name: "first_service_return_points_won")
  firstServiceReturnPointsWonPct: String @db(name: "first_service_return_points_won_pct")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tennis_return_stats_id_seq", initialValue: 1, allocationSize: 1)
  matchesPlayed: String @db(name: "matches_played")
  returnGamesPlayed: String @db(name: "return_games_played")
  returnGamesWon: String @db(name: "return_games_won")
  returnGamesWonPct: String @db(name: "return_games_won_pct")
  returnsPlayed: String @db(name: "returns_played")
  secondServiceReturnPointsWon: String @db(name: "second_service_return_points_won")
  secondServiceReturnPointsWonPct: String @db(name: "second_service_return_points_won_pct")
}

type TennisServiceStat @db(name: "tennis_service_stats") {
  aces: String
  breakPointsPlayed: String @db(name: "break_points_played")
  breakPointsSaved: String @db(name: "break_points_saved")
  breakPointsSavedPct: String @db(name: "break_points_saved_pct")
  firstServicePointsWon: String @db(name: "first_service_points_won")
  firstServicePointsWonPct: String @db(name: "first_service_points_won_pct")
  firstServicesGood: String @db(name: "first_services_good")
  firstServicesGoodPct: String @db(name: "first_services_good_pct")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "tennis_service_stats_id_seq", initialValue: 1, allocationSize: 1)
  matchesPlayed: String @db(name: "matches_played")
  secondServicePointsWon: String @db(name: "second_service_points_won")
  secondServicePointsWonPct: String @db(name: "second_service_points_won_pct")
  serviceGamesPlayed: String @db(name: "service_games_played")
  serviceGamesWon: String @db(name: "service_games_won")
  serviceGamesWonPct: String @db(name: "service_games_won_pct")
  servicesPlayed: String @db(name: "services_played")
}

type WageringMoneyline @db(name: "wagering_moneylines") {
  bookmaker: Bookmaker! @db(name: "bookmaker_id")
  comment: String
  dateTime: DateTime @db(name: "date_time")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "wagering_moneylines_id_seq", initialValue: 1, allocationSize: 1)
  line: String
  lineOpening: String @db(name: "line_opening")
  personId: Int @db(name: "person_id")
  prediction: String
  rotationKey: String @db(name: "rotation_key")
  team: Team! @db(name: "team_id")
  vigorish: String
}

type WageringOddsLine @db(name: "wagering_odds_lines") {
  bookmaker: Bookmaker! @db(name: "bookmaker_id")
  comment: String
  dateTime: DateTime @db(name: "date_time")
  denominator: String
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "wagering_odds_lines_id_seq", initialValue: 1, allocationSize: 1)
  numerator: String
  payoutAmount: String @db(name: "payout_amount")
  payoutCalculation: String @db(name: "payout_calculation")
  personId: Int @db(name: "person_id")
  prediction: String
  rotationKey: String @db(name: "rotation_key")
  team: Team! @db(name: "team_id")
}

type WageringRunline @db(name: "wagering_runlines") {
  bookmaker: Bookmaker! @db(name: "bookmaker_id")
  comment: String
  dateTime: DateTime @db(name: "date_time")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "wagering_runlines_id_seq", initialValue: 1, allocationSize: 1)
  line: String
  lineOpening: String @db(name: "line_opening")
  lineValue: String @db(name: "line_value")
  personId: Int @db(name: "person_id")
  prediction: String
  rotationKey: String @db(name: "rotation_key")
  team: Team! @db(name: "team_id")
  vigorish: String
}

type WageringStraightSpreadLine @db(name: "wagering_straight_spread_lines") {
  bookmaker: Bookmaker! @db(name: "bookmaker_id")
  comment: String
  dateTime: DateTime @db(name: "date_time")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "wagering_straight_spread_lines_id_seq", initialValue: 1, allocationSize: 1)
  lineValue: String @db(name: "line_value")
  lineValueOpening: String @db(name: "line_value_opening")
  personId: Int @db(name: "person_id")
  prediction: String
  rotationKey: String @db(name: "rotation_key")
  team: Team! @db(name: "team_id")
  vigorish: String
}

type WageringTotalScoreLine @db(name: "wagering_total_score_lines") {
  bookmaker: Bookmaker! @db(name: "bookmaker_id")
  comment: String
  dateTime: DateTime @db(name: "date_time")
  event: Event! @db(name: "event_id")
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "wagering_total_score_lines_id_seq", initialValue: 1, allocationSize: 1)
  lineOver: String @db(name: "line_over")
  lineUnder: String @db(name: "line_under")
  personId: Int @db(name: "person_id")
  prediction: String
  rotationKey: String @db(name: "rotation_key")
  team: Team! @db(name: "team_id")
  total: String
  totalOpening: String @db(name: "total_opening")
  vigorish: String
}

type WeatherCondition @db(name: "weather_conditions") {
  clouds: String
  event: Event! @db(name: "event_id")
  humidity: String
  id: Int! @id(strategy: SEQUENCE) @sequence(name: "weather_conditions_id_seq", initialValue: 1, allocationSize: 1)
  temperature: String
  temperatureUnits: String @db(name: "temperature_units")
  weatherCode: String @db(name: "weather_code")
  windDirection: String @db(name: "wind_direction")
  windVelocity: String @db(name: "wind_velocity")
}
