package net.rf43.royaleapikit.consumer

import com.google.gson.annotations.SerializedName

object RawConstantsModel {
    data class RawConstant(
        @SerializedName("alliance_badges") val allianceBadges: List<RawConstantAllianceBadge>? = null,
        @SerializedName("arenas") val arenas: List<RawConstantArena>? = null,
        @SerializedName("cards") val cards: List<RawConstantCard>? = null,
        @SerializedName("cards_stats") val cardsStats: RawConstantCardsStats? = null,
        @SerializedName("challenges") val challenges: List<RawConstantChallenge>? = null,
        @SerializedName("chest_order") val chestOrder: RawConstantChestOrder? = null,
        @SerializedName("clan_chest") val clan_chest: RawConstantClanChest? = null,
        @SerializedName("game_modes") val game_modes: List<RawConstantGameModes>? = null,
        @SerializedName("rarities") val rarities: List<RawConstantRarites>? = null,
        @SerializedName("regions") val regions: List<RawConstantRegions>? = null,
        @SerializedName("tournaments") val tournaments: List<RawConstantTournaments>? = null,
        @SerializedName("treasure_chests") val treasure_chests: RawConstantTreasureChests? = null
    )

    data class RawConstantAllianceBadge(
        @SerializedName("name") val name: String? = null,
        @SerializedName("category") val category: String? = null,
        @SerializedName("id") val id: Int? = null
    )

    data class RawConstantArena(
        @SerializedName("name") val name: String? = null,
        @SerializedName("arena") val arena: Int? = null,
        @SerializedName("chest_arena") val chestArena: String? = null,
        @SerializedName("tv_arena") val tvArena: String? = null,
        @SerializedName("is_in_use") val isInUse: Boolean? = null,
        @SerializedName("training_camp") val trainingCamp: Boolean? = null,
        @SerializedName("trophy_limit") val trophyLimit: Int? = null,
        @SerializedName("demote_trophy_limit") val demoteTrophyLimit: Int? = null,
        @SerializedName("chest_reward_multiplier") val chestRewardMultiplier: Int? = null,
        @SerializedName("shop_chest_reward_multiplier") val shopChestRewardMultiplier: Int? = null,
        @SerializedName("request_size") val requestSize: Int? = null,
        @SerializedName("max_donation_count_common") val maxDonationCountCommon: Int? = null,
        @SerializedName("max_donation_count_rare") val maxDonationCountRare: Int? = null,
        @SerializedName("max_donation_count_epic") val maxDonationCountEpic: Int? = null,
        @SerializedName("matchmaking_min_trophy_delta") val matchmakingMinTrophyDelta: Int? = null,
        @SerializedName("matchmaking_max_trophy_delta") val matchmakingMaxTrophyDelta: Int? = null,
        @SerializedName("matchmaking_max_seconds") val matchmakingMaxSeconds: Int? = null,
        @SerializedName("daily_donation_capacity_limit") val dailyDonationCapacityLimit: Int? = null,
        @SerializedName("battle_reward_gold") val battleRewardGold: Int? = null,
        @SerializedName("season_reward_chest") val seasonRewardChest: Any? = null,
        @SerializedName("quest_cycle") val questCycle: String? = null,
        @SerializedName("key") val key: String? = null,
        @SerializedName("title") val title: String? = null,
        @SerializedName("subtitle") val subtitle: String? = null,
        @SerializedName("arena_id") val arenaId: Int? = null,
        @SerializedName("league_id") val leagueId: String? = null,
        @SerializedName("id") val id: Int? = null
    )

    data class RawConstantCard(
        @SerializedName("key") val key: String? = null,
        @SerializedName("name") val name: String? = null,
        @SerializedName("elixir") val elixir: Int? = null,
        @SerializedName("type") val type: String? = null,
        @SerializedName("rarity") val rarity: String? = null,
        @SerializedName("arena") val arena: Int? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("id") val id: Int? = null
    )

    //region CardStats
    data class RawConstantCardsStats(
        @SerializedName("troop") val troops: List<RawConstantCardsStatsTroop>? = null,
        @SerializedName("building") val building: List<RawConstantCardsStatsBuilding>? = null,
        @SerializedName("spell") val spell: List<RawConstantCardsStatsSpell>? = null,
        @SerializedName("projectile") val projectile: List<RawConstantCardsStatsProjectile>? = null
    )

    data class RawConstantCardsStatsTroop(
        @SerializedName("name") val name: String? = null,
        @SerializedName("rarity") val rarity: String? = null,
        @SerializedName("sight_range") val sight_range: Int? = null,
        @SerializedName("deploy_time") val deploy_time: Int? = null,
        @SerializedName("speed") val speed: Int? = null,
        @SerializedName("hitpoints") val hitpoints: Int? = null,
        @SerializedName("hit_speed") val hit_speed: Int? = null,
        @SerializedName("load_time") val load_time: Int? = null,
        @SerializedName("damage") val damage: Int? = null,
        @SerializedName("load_first_hit") val load_first_hit: Boolean? = null,
        @SerializedName("load_after_retarget") val load_after_retarget: Boolean? = null,
        @SerializedName("all_targets_hit") val all_targets_hit: Boolean? = null,
        @SerializedName("range") val range: Int? = null,
        @SerializedName("attacks_ground") val attacks_ground: Boolean? = null,
        @SerializedName("attacks_air") val attacks_air: Boolean? = null,
        @SerializedName("target_only_buildings") val target_only_buildings: Boolean? = null,
        @SerializedName("target_only_troops") val target_only_troops: Boolean? = null,
        @SerializedName("prestige_swf") val prestige_swf: String? = null,
        @SerializedName("prestige_export_name2") val prestige_export_name2: String? = null,
        @SerializedName("spawn_effect_once") val spawn_effect_once: Boolean? = null,
        @SerializedName("crowd_effects") val crowd_effects: Boolean? = null,
        @SerializedName("ignore_pushback") val ignore_pushback: Boolean? = null,
        @SerializedName("scale") val scale: Int? = null,
        @SerializedName("collision_radius") val collision_radius: Int? = null,
        @SerializedName("mass") val mass: Int? = null,
        @SerializedName("show_health_number") val show_health_number: Boolean? = null,
        @SerializedName("fly_direct_paths") val fly_direct_paths: Boolean? = null,
        @SerializedName("fly_from_ground") val fly_from_ground: Boolean? = null,
        @SerializedName("heal_on_morph") val heal_on_morph: Boolean? = null,
        @SerializedName("morph_keep_target") val morph_keep_target: Boolean? = null,
        @SerializedName("dash_only_once") val dash_only_once: Boolean? = null,
        @SerializedName("destroy_at_limit") val destroy_at_limit: Boolean? = null,
        @SerializedName("spawn_attach") val spawn_attach: Boolean? = null,
        @SerializedName("death_spawn_pushback") val death_spawn_pushback: Boolean? = null,
        @SerializedName("death_inherit_ignore_list") val death_inherit_ignore_list: Boolean? = null,
        @SerializedName("kamikaze") val kamikaze: Boolean? = null,
        @SerializedName("projectile_start_radius") val projectile_start_radius: Int? = null,
        @SerializedName("projectile_start_z") val projectile_start_z: Int? = null,
        @SerializedName("dont_stop_move_anim") val dont_stop_move_anim: Boolean? = null,
        @SerializedName("is_summoner_tower") val is_summoner_tower: Boolean? = null,
        @SerializedName("self_as_aoe_center") val self_as_aoe_center: Boolean? = null,
        @SerializedName("hides_when_not_attacking") val hides_when_not_attacking: Boolean? = null,
        @SerializedName("hide_before_first_hit") val hide_before_first_hit: Boolean? = null,
        @SerializedName("special_attack_when_hidden") val special_attack_when_hidden: Boolean? = null,
        @SerializedName("has_rotation_on_timeline") val has_rotation_on_timeline: Boolean? = null,
        @SerializedName("jump_enabled") val jump_enabled: Boolean? = null,
        @SerializedName("retarget_after_attack") val retarget_after_attack: Boolean? = null,
        @SerializedName("burst_keep_target") val burst_keep_target: Boolean? = null,
        @SerializedName("burst_affect_animation") val burst_affect_animation: Boolean? = null,
        @SerializedName("building_target") val building_target: Boolean? = null,
        @SerializedName("spawn_const_priority") val spawn_const_priority: Boolean? = null,
        @SerializedName("deprioritize_targets_with_buff") val deprioritize_targets_with_buff: Boolean? = null,
        @SerializedName("override_attack_finish_time") val override_attack_finish_time: Boolean? = null,
        @SerializedName("name_en") val name_en: String? = null,
        @SerializedName("key") val key: String? = null,
        @SerializedName("elixir") val elixir: Int? = null,
        @SerializedName("type") val type: String? = null,
        @SerializedName("arena") val arena: Int? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("id") val id: Int? = null,
        @SerializedName("summon_character") val summon_character: String? = null,
        @SerializedName("summon_number") val summon_number: Int? = null,
        @SerializedName("speed_en") val speed_en: String? = null,
        @SerializedName("dps") val dps: Double? = null,
        @SerializedName("hitpoints_per_level") val hitpointsPerLevel: List<Int>? = null,
        @SerializedName("damage_per_level") val damagePerLevel: List<Int>? = null,
        @SerializedName("dps_per_level") val dpsPerLevel: List<Int>? = null
    )

    data class RawConstantCardsStatsBuilding(
        @SerializedName("name") val name: String? = null,
        @SerializedName("rarity") val rarity: String? = null,
        @SerializedName("sight_range") val sight_range: Int? = null,
        @SerializedName("hitpoints") val hitpoints: Int? = null,
        @SerializedName("hit_speed") val hit_speed: Int? = null,
        @SerializedName("load_time") val load_time: Int? = null,
        @SerializedName("load_first_hit") val load_first_hit: Boolean? = null,
        @SerializedName("load_after_retarget") val load_after_retarget: Boolean? = null,
        @SerializedName("projectile") val projectile: String? = null,
        @SerializedName("all_targets_hit") val all_targets_hit: Boolean? = null,
        @SerializedName("range") val range: Int? = null,
        @SerializedName("attacks_ground") val attacks_ground: Boolean? = null,
        @SerializedName("attacks_air") val attacks_air: Boolean? = null,
        @SerializedName("target_only_buildings") val target_only_buildings: Boolean? = null,
        @SerializedName("target_only_troops") val target_only_troops: Boolean? = null,
        @SerializedName("prestige_swf") val prestige_swf: String? = null,
        @SerializedName("attached_character_height") val attached_character_height: Int? = null,
        @SerializedName("spawn_effect_once") val spawn_effect_once: Boolean? = null,
        @SerializedName("crowd_effects") val crowd_effects: Boolean? = null,
        @SerializedName("ignore_pushback") val ignore_pushback: Boolean? = null,
        @SerializedName("scale") val scale: Int? = null,
        @SerializedName("collision_radius") val collision_radius: Int? = null,
        @SerializedName("tile_size_override") val tile_size_override: Int? = null,
        @SerializedName("show_health_number") val show_health_number: Boolean? = null,
        @SerializedName("fly_direct_paths") val fly_direct_paths: Boolean? = null,
        @SerializedName("fly_from_ground") val fly_from_ground: Boolean? = null,
        @SerializedName("heal_on_morph") val heal_on_morph: Boolean? = null,
        @SerializedName("morph_keep_target") val morph_keep_target: Boolean? = null,
        @SerializedName("dash_only_once") val dash_only_once: Boolean? = null,
        @SerializedName("destroy_at_limit") val destroy_at_limit: Boolean? = null,
        @SerializedName("spawn_attach") val spawn_attach: Boolean? = null,
        @SerializedName("death_spawn_pushback") val death_spawn_pushback: Boolean? = null,
        @SerializedName("death_inherit_ignore_list") val death_inherit_ignore_list: Boolean? = null,
        @SerializedName("kamikaze") val kamikaze: Boolean? = null,
        @SerializedName("projectile_start_radius") val projectile_start_radius: Int? = null,
        @SerializedName("projectile_start_z") val projectile_start_z: Int? = null,
        @SerializedName("dont_stop_move_anim") val dont_stop_move_anim: Boolean? = null,
        @SerializedName("is_summoner_tower") val is_summoner_tower: Boolean? = null,
        @SerializedName("no_deploy_size_w") val no_deploy_size_w: Int? = null,
        @SerializedName("no_deploy_size_h") val no_deploy_size_h: Int? = null,
        @SerializedName("self_as_aoe_center") val self_as_aoe_center: Boolean? = null,
        @SerializedName("hides_when_not_attacking") val hides_when_not_attacking: Boolean? = null,
        @SerializedName("hide_before_first_hit") val hide_before_first_hit: Boolean? = null,
        @SerializedName("special_attack_when_hidden") val special_attack_when_hidden: Boolean? = null,
        @SerializedName("has_rotation_on_timeline") val has_rotation_on_timeline: Boolean? = null,
        @SerializedName("turret_movement") val turret_movement: Int? = null,
        @SerializedName("projectile_y_offset") val projectile_y_offset: Int? = null,
        @SerializedName("jump_enabled") val jump_enabled: Boolean? = null,
        @SerializedName("retarget_after_attack") val retarget_after_attack: Boolean? = null,
        @SerializedName("burst_keep_target") val burst_keep_target: Boolean? = null,
        @SerializedName("burst_affect_animation") val burst_affect_animation: Boolean? = null,
        @SerializedName("building_target") val building_target: Boolean? = null,
        @SerializedName("spawn_const_priority") val spawn_const_priority: Boolean? = null,
        @SerializedName("deprioritize_targets_with_buff") val deprioritize_targets_with_buff: Boolean? = null,
        @SerializedName("override_attack_finish_time") val override_attack_finish_time: Boolean? = null,
        @SerializedName("name_en") val name_en: String? = null,
        @SerializedName("hitpoints_per_level") val hitpoints_per_level: List<Int>? = null,
        @SerializedName("damage_per_level") val damage_per_level: List<Int>? = null,
        @SerializedName("dps_per_level") val dps_per_level: List<Int>? = null
    )

    data class RawConstantCardsStatsSpell(
        @SerializedName("name") val name: String? = null,
        @SerializedName("rarity") val rarity: String? = null,
        @SerializedName("life_duration") val life_duration: Int? = null,
        @SerializedName("life_duration_increase_per_level") val life_duration_increase_per_level: Int? = null,
        @SerializedName("life_duration_increase_after_tournament_cap") val life_duration_increase_after_tournament_cap: Int? = null,
        @SerializedName("affects_hidden") val affects_hidden: Boolean? = null,
        @SerializedName("radius") val radius: Int? = null,
        @SerializedName("hit_speed") val hit_speed: Int? = null,
        @SerializedName("damage") val damage: Int? = null,
        @SerializedName("no_effect_to_crown_towers") val no_effect_to_crown_towers: Boolean? = null,
        @SerializedName("crown_tower_damage_percent") val crown_tower_damage_percent: Int? = null,
        @SerializedName("hit_biggest_targets") val hit_biggest_targets: Boolean? = null,
        @SerializedName("buff") val buff: String? = null,
        @SerializedName("buff_time") val buff_time: Int? = null,
        @SerializedName("buff_time_increase_per_level") val buff_time_increase_per_level: Int? = null,
        @SerializedName("buff_time_increase_after_tournament_cap") val buff_time_increase_after_tournament_cap: Int? = null,
        @SerializedName("cap_buff_time_to_area_effect_time") val cap_buff_time_to_area_effect_time: Boolean? = null,
        @SerializedName("buff_number") val buff_number: Int? = null,
        @SerializedName("only_enemies") val only_enemies: Boolean? = null,
        @SerializedName("only_own_troops") val only_own_troops: Boolean? = null,
        @SerializedName("ignore_buildings") val ignore_buildings: Boolean? = null,
        @SerializedName("ignore_hero") val ignore_hero: Boolean? = null,
        @SerializedName("projectile") val projectile: Any? = null,
        @SerializedName("spawn_character") val spawn_character: Any? = null,
        @SerializedName("spawn_interval") val spawn_interval: Int? = null,
        @SerializedName("spawn_randomize_sequence") val spawn_randomize_sequence: Boolean? = null,
        @SerializedName("spawn_deploy_base_anim") val spawn_deploy_base_anim: Any? = null,
        @SerializedName("spawn_time") val spawn_time: Int? = null,
        @SerializedName("spawn_character_level_index") val spawn_character_level_index: Int? = null,
        @SerializedName("spawn_initial_delay") val spawn_initial_delay: Int? = null,
        @SerializedName("spawn_max_count") val spawn_max_count: Int? = null,
        @SerializedName("spawn_max_radius") val spawn_max_radius: Int? = null,
        @SerializedName("spawn_min_radius") val spawn_min_radius: Int? = null,
        @SerializedName("spawn_from_min_to_max") val spawn_from_min_to_max: Boolean? = null,
        @SerializedName("spawn_angle_shift") val spawn_angle_shift: Int? = null,
        @SerializedName("hits_ground") val hits_ground: Boolean? = null,
        @SerializedName("hits_air") val hits_air: Boolean? = null,
        @SerializedName("key") val key: String? = null,
        @SerializedName("elixir") val elixir: Int? = null,
        @SerializedName("type") val type: String? = null,
        @SerializedName("arena") val arena: Int? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("id") val id: Int? = null,
        @SerializedName("hitpoints_per_level") val hitpoints_per_level: List<Int>? = null,
        @SerializedName("damage_per_level") val damage_per_level: List<Int>? = null,
        @SerializedName("dps_per_level") val dps_per_level: List<Int>? = null
    )

    data class RawConstantCardsStatsProjectile(
        @SerializedName("name") val name: String? = null,
        @SerializedName("rarity") val rarity: String? = null,
        @SerializedName("speed") val speed: Int? = null,
        @SerializedName("homing") val homing: Boolean? = null,
        @SerializedName("hit_effect_at_projectile") val hit_effect_at_projectile: Boolean? = null,
        @SerializedName("damage") val damage: Int? = null,
        @SerializedName("crown_tower_damage_percent") val crown_tower_damage_percent: Int? = null,
        @SerializedName("radius") val radius: Int? = null,
        @SerializedName("aoe_to_air") val aoe_to_air: Boolean? = null,
        @SerializedName("aoe_to_ground") val aoe_to_ground: Boolean? = null,
        @SerializedName("only_enemies") val only_enemies: Boolean? = null,
        @SerializedName("only_own_troops") val only_own_troops: Boolean? = null,
        @SerializedName("gravity") val gravity: Int? = null,
        @SerializedName("spawn_const_priority") val spawn_const_priority: Boolean? = null,
        @SerializedName("use360_frames") val use360_frames: Boolean? = null,
        @SerializedName("height_from_target_radius") val height_from_target_radius: Boolean? = null,
        @SerializedName("target_to_edge") val target_to_edge: Boolean? = null,
        @SerializedName("shakes_targets") val shakes_targets: Boolean? = null,
        @SerializedName("check_collisions") val check_collisions: Boolean? = null,
        @SerializedName("damage_per_level") val damage_per_level: List<Int>? = null,
        @SerializedName("dps") val dps: Int? = null,
        @SerializedName("dps_per_level") val dps_per_level: List<Int>? = null
    )
    //endregion

    data class RawConstantChallenge(
        @SerializedName("name") val name: String? = null,
        @SerializedName("game_mode") val game_mode: String? = null,
        @SerializedName("enabled") val enabled: Boolean? = null,
        @SerializedName("join_cost") val join_cost: Int? = null,
        @SerializedName("join_cost_resource") val join_cost_resource: String? = null,
        @SerializedName("max_wins") val max_wins: Int? = null,
        @SerializedName("max_loss") val max_loss: Int? = null,
        @SerializedName("reward_cards") val reward_cards: List<Int>? = null,
        @SerializedName("reward_gold") val reward_gold: List<Int>? = null,
        @SerializedName("reward_spell") val reward_spell: Any? = null,
        @SerializedName("reward_spell_max_count") val reward_spell_max_count: Int? = null,
        @SerializedName("name_en") val name_en: String? = null,
        @SerializedName("key") val key: String? = null,
        @SerializedName("id") val id: Int? = null
    )

    //region ChestOrder
    data class RawConstantChestOrder(
        @SerializedName("MainCycle") val mainCycle: List<String>? = null,
        @SerializedName("Quest_earlygame_1") val questEarlygame_1: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_earlygame_2") val questEarlygame_2: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_1") val questLategame_1: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_2") val questLategame_2: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_3") val questLategame_3: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_4") val questLategame_4: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_5") val questLategame_5: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_6") val questLategame_6: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_7") val questLategame_7: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_8") val questLategame_8: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_9") val questLategame_9: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_lategame_10") val questLategame_10: List<RawConstantChestOrderGame>? = null,
        @SerializedName("Quest_arena3_UNUSED") val questArena3_UNUSED: List<RawConstantChestOrderGame>? = null
    )

    data class RawConstantChestOrderGame(
        @SerializedName("chest") val chest: String? = null,
        @SerializedName("arena_threshold") val arena_threshold: String? = null,
        @SerializedName("one_time") val one_time: Any? = null
    )
    //endregion

    //region Clan Chest
    data class RawConstantClanChest(
        @SerializedName("1v1") val oneVsOne: RawConstantClanChest1v1? = null,
        @SerializedName("2v2") val twoVsTwo: RawConstantClanChest2v2? = null
    )

    data class RawConstantClanChest1v1(
        @SerializedName("thresholds") val thresholds: List<Int>? = null,
        @SerializedName("gold") val gold: List<Int>? = null,
        @SerializedName("cards") val cards: List<Int>? = null
    )

    data class RawConstantClanChest2v2(
        @SerializedName("thresholds") val thresholds: List<Int>? = null,
        @SerializedName("gold") val gold: List<Int>? = null,
        @SerializedName("cards") val cards: List<Int>? = null
    )
    //endregion

    data class RawConstantGameModes(
        @SerializedName("name") val name: String? = null,
        @SerializedName("card_level_adjustment") val card_level_adjustment: String? = null,
        @SerializedName("deck_selection") val deck_selection: String? = null,
        @SerializedName("overtime_seconds") val overtime_seconds: Int? = null,
        @SerializedName("predefined_decks") val predefined_decks: String? = null,
        @SerializedName("same_deck_on_both") val same_deck_on_both: Boolean? = null,
        @SerializedName("separate_team_decks") val separate_team_decks: Boolean? = null,
        @SerializedName("swapping_towers") val swapping_towers: Boolean? = null,
        @SerializedName("use_starting_elixir") val use_starting_elixir: Boolean? = null,
        @SerializedName("heroes") val heroes: Boolean? = null,
        @SerializedName("players") val players: String? = null,
        @SerializedName("gives_clan_score") val gives_clan_score: Boolean? = null,
        @SerializedName("fixed_deck_order") val fixed_deck_order: Boolean? = null,
        @SerializedName("clan_war_description") val clan_war_description: String? = null,
        @SerializedName("battle_start_cooldown") val battle_start_cooldown: Int? = null,
        @SerializedName("heist") val heist: Boolean? = null,
        @SerializedName("id") val id: Int? = null,
        @SerializedName("name_en") val name_en: String? = null
    )

    data class RawConstantRarites(
        @SerializedName("name") val name: String? = null,
        @SerializedName("level_count") val level_count: Int? = null,
        @SerializedName("relative_level") val relative_level: Int? = null,
        @SerializedName("mirror_relative_level") val mirror_relative_level: Int? = null,
        @SerializedName("clone_relative_level") val clone_relative_level: Int? = null,
        @SerializedName("donate_capacity") val donate_capacity: Int? = null,
        @SerializedName("sort_capacity") val sort_capacity: Int? = null,
        @SerializedName("donate_reward") val donate_reward: Int? = null,
        @SerializedName("donate_xp") val donate_xp: Int? = null,
        @SerializedName("gold_conversion_value") val gold_conversion_value: Int? = null,
        @SerializedName("chance_weight") val chance_weight: Int? = null,
        @SerializedName("balance_multiplier") val balance_multiplier: Int? = null,
        @SerializedName("upgrade_exp") val upgrade_exp: List<Int>? = null,
        @SerializedName("upgrade_material_count") val upgrade_material_count: List<Int>? = null,
        @SerializedName("upgrade_cost") val upgrade_cost: List<Int>? = null,
        @SerializedName("power_level_multiplier") val power_level_multiplier: List<Int>? = null,
        @SerializedName("refund_gems") val refund_gems: Int? = null
    )

    data class RawConstantRegions(
        @SerializedName("id") val id: Int? = null,
        @SerializedName("key") val key: String? = null,
        @SerializedName("name") val name: String? = null,
        @SerializedName("isCountry") val isCountry: Boolean? = null
    )

    data class RawConstantTournaments(
        @SerializedName("create_cost") val create_cost: Int? = null,
        @SerializedName("max_players") val max_players: Int? = null,
        @SerializedName("key") val key: String? = null,
        @SerializedName("prizes") val prizes: Any? = null,
        @SerializedName("cards") val cards: List<Int>? = null
    )

    //region Treasure Chests
    data class RawConstantTreasureChests(
        @SerializedName("cycle") val cycle: List<RawConstantTreasureChestsCycle>? = null,
        @SerializedName("crown") val crown: List<RawConstantTreasureChestsCrown>? = null,
        @SerializedName("shop") val shop: List<RawConstantTreasureChestsShop>? = null
    )

    data class RawConstantTreasureChestsCycle(
        @SerializedName("name") val name: String? = null,
        @SerializedName("base_chest") val base_chest: Any? = null,
        @SerializedName("arena") val arena: RawConstantTreasureChestsArena? = null,
        @SerializedName("in_shop") val in_shop: Boolean? = null,
        @SerializedName("in_arena_info") val in_arena_info: Boolean? = null,
        @SerializedName("tournament_chest") val tournament_chest: Boolean? = null,
        @SerializedName("survival_chest") val survival_chest: Boolean? = null,
        @SerializedName("shop_price_without_speed_up") val shop_price_without_speed_up: Int? = null,
        @SerializedName("time_taken_days") val time_taken_days: Int? = null,
        @SerializedName("time_taken_hours") val time_taken_hours: Int? = null,
        @SerializedName("time_taken_minutes") val time_taken_minutes: Int? = null,
        @SerializedName("time_taken_seconds") val time_taken_seconds: Int? = null,
        @SerializedName("random_spells") val random_spells: Int? = null,
        @SerializedName("different_spells") val different_spells: Int? = null,
        @SerializedName("chest_count_in_chest_cycle") val chest_count_in_chest_cycle: Int? = null,
        @SerializedName("rare_chance") val rare_chance: Int? = null,
        @SerializedName("epic_chance") val epic_chance: Int? = null,
        @SerializedName("legendary_chance") val legendary_chance: Int? = null,
        @SerializedName("skin_chance") val skin_chance: Int? = null,
        @SerializedName("guaranteed_spells") val guaranteed_spells: Any? = null,
        @SerializedName("min_gold_per_card") val min_gold_per_card: Int? = null,
        @SerializedName("max_gold_per_card") val max_gold_per_card: Int? = null,
        @SerializedName("spell_set") val spell_set: Any? = null,
        @SerializedName("exp") val exp: Int? = null,
        @SerializedName("sort_value") val sort_value: Int? = null,
        @SerializedName("special_offer") val special_offer: Boolean? = null,
        @SerializedName("draft_chest") val draft_chest: Boolean? = null,
        @SerializedName("boosted_chest") val boosted_chest: Boolean? = null,
        @SerializedName("legendary_override_chance") val legendary_override_chance: Int? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("notification") val notification: String? = null,
        @SerializedName("card_count") val card_count: Int? = null,
        @SerializedName("min_gold") val min_gold: Int? = null,
        @SerializedName("max_gold") val max_gold: Int? = null,
        @SerializedName("arenas") val arenas: List<RawConstantTreasureChestsArena>? = null
    )

    data class RawConstantTreasureChestsCrown(
        @SerializedName("name") val name: String? = null,
        @SerializedName("base_chest") val base_chest: Any? = null,
        @SerializedName("arena") val arena: RawConstantTreasureChestsArena? = null,
        @SerializedName("in_shop") val in_shop: Boolean? = null,
        @SerializedName("in_arena_info") val in_arena_info: Boolean? = null,
        @SerializedName("tournament_chest") val tournament_chest: Boolean? = null,
        @SerializedName("survival_chest") val survival_chest: Boolean? = null,
        @SerializedName("shop_price_without_speed_up") val shop_price_without_speed_up: Int? = null,
        @SerializedName("time_taken_days") val time_taken_days: Int? = null,
        @SerializedName("time_taken_hours") val time_taken_hours: Int? = null,
        @SerializedName("time_taken_minutes") val time_taken_minutes: Int? = null,
        @SerializedName("time_taken_seconds") val time_taken_seconds: Int? = null,
        @SerializedName("random_spells") val random_spells: Int? = null,
        @SerializedName("different_spells") val different_spells: Int? = null,
        @SerializedName("chest_count_in_chest_cycle") val chest_count_in_chest_cycle: Int? = null,
        @SerializedName("rare_chance") val rare_chance: Int? = null,
        @SerializedName("epic_chance") val epic_chance: Int? = null,
        @SerializedName("legendary_chance") val legendary_chance: Int? = null,
        @SerializedName("skin_chance") val skin_chance: Int? = null,
        @SerializedName("guaranteed_spells") val guaranteed_spells: Any? = null,
        @SerializedName("min_gold_per_card") val min_gold_per_card: Int? = null,
        @SerializedName("max_gold_per_card") val max_gold_per_card: Int? = null,
        @SerializedName("spell_set") val spell_set: Any? = null,
        @SerializedName("exp") val exp: Int? = null,
        @SerializedName("sort_value") val sort_value: Int? = null,
        @SerializedName("special_offer") val special_offer: Boolean? = null,
        @SerializedName("draft_chest") val draft_chest: Boolean? = null,
        @SerializedName("boosted_chest") val boosted_chest: Boolean? = null,
        @SerializedName("legendary_override_chance") val legendary_override_chance: Int? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("notification") val notification: String? = null,
        @SerializedName("card_count") val card_count: Int? = null,
        @SerializedName("min_gold") val min_gold: Int? = null,
        @SerializedName("max_gold") val max_gold: Int? = null,
        @SerializedName("arenas") val arenas: List<RawConstantTreasureChestsArena>? = null
    )

    data class RawConstantTreasureChestsShop(
        @SerializedName("name") val name: String? = null,
        @SerializedName("base_chest") val base_chest: Any? = null,
        @SerializedName("arena") val arena: RawConstantTreasureChestsArena? = null,
        @SerializedName("in_shop") val in_shop: Boolean? = null,
        @SerializedName("in_arena_info") val in_arena_info: Boolean? = null,
        @SerializedName("tournament_chest") val tournament_chest: Boolean? = null,
        @SerializedName("survival_chest") val survival_chest: Boolean? = null,
        @SerializedName("shop_price_without_speed_up") val shop_price_without_speed_up: Int? = null,
        @SerializedName("time_taken_days") val time_taken_days: Int? = null,
        @SerializedName("time_taken_hours") val time_taken_hours: Int? = null,
        @SerializedName("time_taken_minutes") val time_taken_minutes: Int? = null,
        @SerializedName("time_taken_seconds") val time_taken_seconds: Int? = null,
        @SerializedName("random_spells") val random_spells: Int? = null,
        @SerializedName("different_spells") val different_spells: Int? = null,
        @SerializedName("chest_count_in_chest_cycle") val chest_count_in_chest_cycle: Int? = null,
        @SerializedName("rare_chance") val rare_chance: Int? = null,
        @SerializedName("epic_chance") val epic_chance: Int? = null,
        @SerializedName("legendary_chance") val legendary_chance: Int? = null,
        @SerializedName("skin_chance") val skin_chance: Int? = null,
        @SerializedName("guaranteed_spells") val guaranteed_spells: Any? = null,
        @SerializedName("min_gold_per_card") val min_gold_per_card: Int? = null,
        @SerializedName("max_gold_per_card") val max_gold_per_card: Int? = null,
        @SerializedName("spell_set") val spell_set: Any? = null,
        @SerializedName("exp") val exp: Int? = null,
        @SerializedName("sort_value") val sort_value: Int? = null,
        @SerializedName("special_offer") val special_offer: Boolean? = null,
        @SerializedName("draft_chest") val draft_chest: Boolean? = null,
        @SerializedName("boosted_chest") val boosted_chest: Boolean? = null,
        @SerializedName("legendary_override_chance") val legendary_override_chance: Int? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("notification") val notification: String? = null,
        @SerializedName("card_count") val card_count: Int? = null,
        @SerializedName("min_gold") val min_gold: Int? = null,
        @SerializedName("max_gold") val max_gold: Int? = null,
        @SerializedName("arenas") val arenas: List<RawConstantTreasureChestsArena>? = null
    )

    data class RawConstantTreasureChestsArena(
        @SerializedName("name") val name: String? = null,
        @SerializedName("arena") val arena: Int? = null,
        @SerializedName("chest_reward_multiplier") val chest_reward_multiplier: Int? = null,
        @SerializedName("shop_chest_reward_multiplier") val shop_chest_reward_multiplier: Int? = null,
        @SerializedName("key") val key: String? = null,
        @SerializedName("title") val title: String? = null,
        @SerializedName("subtitle") val subtitle: String? = null,
        @SerializedName("card_count_by_arena") val card_count_by_arena: Double? = null,
        @SerializedName("card_count_common") val card_count_common: Double? = null,
        @SerializedName("card_count_rare") val card_count_rare: Double? = null,
        @SerializedName("card_count_epic") val card_count_epic: Double? = null,
        @SerializedName("card_count_legendary") val card_count_legendary: Double? = null
    )
    //endregion
}