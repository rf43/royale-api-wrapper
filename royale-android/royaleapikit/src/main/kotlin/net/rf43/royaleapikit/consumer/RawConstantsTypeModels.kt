package net.rf43.royaleapikit.consumer

import android.content.Context
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

object RawConstantsModel {
    data class RawConstant(
        @SerializedName("alliance_badges") val allianceBadges: List<RawConstantAllianceBadge>?,
        @SerializedName("arenas") val arenas: List<RawConstantArena>?,
        @SerializedName("cards") val cards: List<RawConstantCard>?,
        @SerializedName("cards_stats") val cardsStats: RawConstantCardsStats?
    )

    data class RawConstantAllianceBadge(
        @SerializedName("name") val name: String?,
        @SerializedName("category") val category: String?,
        @SerializedName("id") val id: Int?
    )

    data class RawConstantArena(
        @SerializedName("name") val name: String?,
        @SerializedName("arena") val arena: Int?,
        @SerializedName("chest_arena") val chestArena: String?,
        @SerializedName("tv_arena") val tvArena: String?,
        @SerializedName("is_in_use") val isInUse: Boolean?,
        @SerializedName("training_camp") val trainingCamp: Boolean?,
        @SerializedName("trophy_limit") val trophyLimit: Int?,
        @SerializedName("demote_trophy_limit") val demoteTrophyLimit: Int?,
        @SerializedName("chest_reward_multiplier") val chestRewardMultiplier: Int?,
        @SerializedName("shop_chest_reward_multiplier") val shopChestRewardMultiplier: Int?,
        @SerializedName("request_size") val requestSize: Int?,
        @SerializedName("max_donation_count_common") val maxDonationCountCommon: Int?,
        @SerializedName("max_donation_count_rare") val maxDonationCountRare: Int?,
        @SerializedName("max_donation_count_epic") val maxDonationCountEpic: Int?,
        @SerializedName("matchmaking_min_trophy_delta") val matchmakingMinTrophyDelta: Int?,
        @SerializedName("matchmaking_max_trophy_delta") val matchmakingMaxTrophyDelta: Int?,
        @SerializedName("matchmaking_max_seconds") val matchmakingMaxSeconds: Int?,
        @SerializedName("daily_donation_capacity_limit") val dailyDonationCapacityLimit: Int?,
        @SerializedName("battle_reward_gold") val battleRewardGold: Int?,
        @SerializedName("season_reward_chest") val seasonRewardChest: Any?,
        @SerializedName("quest_cycle") val questCycle: String?,
        @SerializedName("key") val key: String?,
        @SerializedName("title") val title: String?,
        @SerializedName("subtitle") val subtitle: String?,
        @SerializedName("arena_id") val arenaId: Int?,
        @SerializedName("league_id") val leagueId: String?,
        @SerializedName("id") val id: Int?
    )

    data class RawConstantCard(
        @SerializedName("key") val key: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("elixir") val elixir: Int?,
        @SerializedName("type") val type: String?,
        @SerializedName("rarity") val rarity: String?,
        @SerializedName("arena") val arena: Int?,
        @SerializedName("description") val description: String?,
        @SerializedName("id") val id: Int?
    )

    data class RawConstantCardsStats(
        @SerializedName("troop") val troops: List<RawConstantCardsStatsTroop>?,
        @SerializedName("building") val building: List<RawConstantCardsStatsBuilding>?,
        @SerializedName("spell") val spell: List<RawConstantCardsStatsSpell>?,
        @SerializedName("projectile") val projectile: List<RawConstantCardsStatsProjectile>?
    )

    data class RawConstantCardsStatsTroop(
        @SerializedName("name") val name: String?,
        @SerializedName("rarity") val rarity: String?,
        @SerializedName("sight_range") val sight_range: Int?,
        @SerializedName("deploy_time") val deploy_time: Int?,
        @SerializedName("speed") val speed: Int?,
        @SerializedName("hitpoints") val hitpoints: Int?,
        @SerializedName("hit_speed") val hit_speed: Int?,
        @SerializedName("load_time") val load_time: Int?,
        @SerializedName("damage") val damage: Int?,
        @SerializedName("load_first_hit") val load_first_hit: Boolean?,
        @SerializedName("load_after_retarget") val load_after_retarget: Boolean?,
        @SerializedName("all_targets_hit") val all_targets_hit: Boolean?,
        @SerializedName("range") val range: Int?,
        @SerializedName("attacks_ground") val attacks_ground: Boolean?,
        @SerializedName("attacks_air") val attacks_air: Boolean?,
        @SerializedName("target_only_buildings") val target_only_buildings: Boolean?,
        @SerializedName("target_only_troops") val target_only_troops: Boolean?,
        @SerializedName("prestige_swf") val prestige_swf: String?,
        @SerializedName("prestige_export_name2") val prestige_export_name2: String?,
        @SerializedName("spawn_effect_once") val spawn_effect_once: Boolean?,
        @SerializedName("crowd_effects") val crowd_effects: Boolean?,
        @SerializedName("ignore_pushback") val ignore_pushback: Boolean?,
        @SerializedName("scale") val scale: Int?,
        @SerializedName("collision_radius") val collision_radius: Int?,
        @SerializedName("mass") val mass: Int?,
        @SerializedName("show_health_number") val show_health_number: Boolean?,
        @SerializedName("fly_direct_paths") val fly_direct_paths: Boolean?,
        @SerializedName("fly_from_ground") val fly_from_ground: Boolean?,
        @SerializedName("heal_on_morph") val heal_on_morph: Boolean?,
        @SerializedName("morph_keep_target") val morph_keep_target: Boolean?,
        @SerializedName("dash_only_once") val dash_only_once: Boolean?,
        @SerializedName("destroy_at_limit") val destroy_at_limit: Boolean?,
        @SerializedName("spawn_attach") val spawn_attach: Boolean?,
        @SerializedName("death_spawn_pushback") val death_spawn_pushback: Boolean?,
        @SerializedName("death_inherit_ignore_list") val death_inherit_ignore_list: Boolean?,
        @SerializedName("kamikaze") val kamikaze: Boolean?,
        @SerializedName("projectile_start_radius") val projectile_start_radius: Int?,
        @SerializedName("projectile_start_z") val projectile_start_z: Int?,
        @SerializedName("dont_stop_move_anim") val dont_stop_move_anim: Boolean?,
        @SerializedName("is_summoner_tower") val is_summoner_tower: Boolean?,
        @SerializedName("self_as_aoe_center") val self_as_aoe_center: Boolean?,
        @SerializedName("hides_when_not_attacking") val hides_when_not_attacking: Boolean?,
        @SerializedName("hide_before_first_hit") val hide_before_first_hit: Boolean?,
        @SerializedName("special_attack_when_hidden") val special_attack_when_hidden: Boolean?,
        @SerializedName("has_rotation_on_timeline") val has_rotation_on_timeline: Boolean?,
        @SerializedName("jump_enabled") val jump_enabled: Boolean?,
        @SerializedName("retarget_after_attack") val retarget_after_attack: Boolean?,
        @SerializedName("burst_keep_target") val burst_keep_target: Boolean?,
        @SerializedName("burst_affect_animation") val burst_affect_animation: Boolean?,
        @SerializedName("building_target") val building_target: Boolean?,
        @SerializedName("spawn_const_priority") val spawn_const_priority: Boolean?,
        @SerializedName("deprioritize_targets_with_buff") val deprioritize_targets_with_buff: Boolean?,
        @SerializedName("override_attack_finish_time") val override_attack_finish_time: Boolean?,
        @SerializedName("name_en") val name_en: String?,
        @SerializedName("key") val key: String?,
        @SerializedName("elixir") val elixir: Int?,
        @SerializedName("type") val type: String?,
        @SerializedName("arena") val arena: Int?,
        @SerializedName("description") val description: String?,
        @SerializedName("id") val id: Int?,
        @SerializedName("summon_character") val summon_character: String?,
        @SerializedName("summon_number") val summon_number: Int?,
        @SerializedName("speed_en") val speed_en: String?,
        @SerializedName("dps") val dps: Double?,
        @SerializedName("hitpoints_per_level") val hitpointsPerLevel: List<Int>?,
        @SerializedName("damage_per_level") val damagePerLevel: List<Int>?,
        @SerializedName("dps_per_level") val dpsPerLevel: List<Int>?
    )

    data class RawConstantCardsStatsBuilding(
        @SerializedName("name") val name: String?,
        @SerializedName("rarity") val rarity: String?,
        @SerializedName("sight_range") val sight_range: Int?,
        @SerializedName("hitpoints") val hitpoints: Int?,
        @SerializedName("hit_speed") val hit_speed: Int?,
        @SerializedName("load_time") val load_time: Int?,
        @SerializedName("load_first_hit") val load_first_hit: Boolean?,
        @SerializedName("load_after_retarget") val load_after_retarget: Boolean?,
        @SerializedName("projectile") val projectile: String?,
        @SerializedName("all_targets_hit") val all_targets_hit: Boolean?,
        @SerializedName("range") val range: Int?,
        @SerializedName("attacks_ground") val attacks_ground: Boolean?,
        @SerializedName("attacks_air") val attacks_air: Boolean?,
        @SerializedName("target_only_buildings") val target_only_buildings: Boolean?,
        @SerializedName("target_only_troops") val target_only_troops: Boolean?,
        @SerializedName("prestige_swf") val prestige_swf: String?,
        @SerializedName("attached_character_height") val attached_character_height: Int?,
        @SerializedName("spawn_effect_once") val spawn_effect_once: Boolean?,
        @SerializedName("crowd_effects") val crowd_effects: Boolean?,
        @SerializedName("ignore_pushback") val ignore_pushback: Boolean?,
        @SerializedName("scale") val scale: Int?,
        @SerializedName("collision_radius") val collision_radius: Int?,
        @SerializedName("tile_size_override") val tile_size_override: Int?,
        @SerializedName("show_health_number") val show_health_number: Boolean?,
        @SerializedName("fly_direct_paths") val fly_direct_paths: Boolean?,
        @SerializedName("fly_from_ground") val fly_from_ground: Boolean?,
        @SerializedName("heal_on_morph") val heal_on_morph: Boolean?,
        @SerializedName("morph_keep_target") val morph_keep_target: Boolean?,
        @SerializedName("dash_only_once") val dash_only_once: Boolean?,
        @SerializedName("destroy_at_limit") val destroy_at_limit: Boolean?,
        @SerializedName("spawn_attach") val spawn_attach: Boolean?,
        @SerializedName("death_spawn_pushback") val death_spawn_pushback: Boolean?,
        @SerializedName("death_inherit_ignore_list") val death_inherit_ignore_list: Boolean?,
        @SerializedName("kamikaze") val kamikaze: Boolean?,
        @SerializedName("projectile_start_radius") val projectile_start_radius: Int?,
        @SerializedName("projectile_start_z") val projectile_start_z: Int?,
        @SerializedName("dont_stop_move_anim") val dont_stop_move_anim: Boolean?,
        @SerializedName("is_summoner_tower") val is_summoner_tower: Boolean?,
        @SerializedName("no_deploy_size_w") val no_deploy_size_w: Int?,
        @SerializedName("no_deploy_size_h") val no_deploy_size_h: Int?,
        @SerializedName("self_as_aoe_center") val self_as_aoe_center: Boolean?,
        @SerializedName("hides_when_not_attacking") val hides_when_not_attacking: Boolean?,
        @SerializedName("hide_before_first_hit") val hide_before_first_hit: Boolean?,
        @SerializedName("special_attack_when_hidden") val special_attack_when_hidden: Boolean?,
        @SerializedName("has_rotation_on_timeline") val has_rotation_on_timeline: Boolean?,
        @SerializedName("turret_movement") val turret_movement: Int?,
        @SerializedName("projectile_y_offset") val projectile_y_offset: Int?,
        @SerializedName("jump_enabled") val jump_enabled: Boolean?,
        @SerializedName("retarget_after_attack") val retarget_after_attack: Boolean?,
        @SerializedName("burst_keep_target") val burst_keep_target: Boolean?,
        @SerializedName("burst_affect_animation") val burst_affect_animation: Boolean?,
        @SerializedName("building_target") val building_target: Boolean?,
        @SerializedName("spawn_const_priority") val spawn_const_priority: Boolean?,
        @SerializedName("deprioritize_targets_with_buff") val deprioritize_targets_with_buff: Boolean?,
        @SerializedName("override_attack_finish_time") val override_attack_finish_time: Boolean?,
        @SerializedName("name_en") val name_en: String?,
        @SerializedName("hitpoints_per_level") val hitpoints_per_level: List<Int>?,
        @SerializedName("damage_per_level") val damage_per_level: List<Int>?,
        @SerializedName("dps_per_level") val dps_per_level: List<Int>?
    )

    data class RawConstantCardsStatsSpell(
        @SerializedName("name") val name: String?,
        @SerializedName("rarity") val rarity: String?,
        @SerializedName("life_duration") val life_duration: Int?,
        @SerializedName("life_duration_increase_per_level") val life_duration_increase_per_level: Int?,
        @SerializedName("life_duration_increase_after_tournament_cap") val life_duration_increase_after_tournament_cap: Int?,
        @SerializedName("affects_hidden") val affects_hidden: Boolean?,
        @SerializedName("radius") val radius: Int?,
        @SerializedName("hit_speed") val hit_speed: Int?,
        @SerializedName("damage") val damage: Int?,
        @SerializedName("no_effect_to_crown_towers") val no_effect_to_crown_towers: Boolean?,
        @SerializedName("crown_tower_damage_percent") val crown_tower_damage_percent: Int?,
        @SerializedName("hit_biggest_targets") val hit_biggest_targets: Boolean?,
        @SerializedName("buff") val buff: String?,
        @SerializedName("buff_time") val buff_time: Int?,
        @SerializedName("buff_time_increase_per_level") val buff_time_increase_per_level: Int?,
        @SerializedName("buff_time_increase_after_tournament_cap") val buff_time_increase_after_tournament_cap: Int?,
        @SerializedName("cap_buff_time_to_area_effect_time") val cap_buff_time_to_area_effect_time: Boolean?,
        @SerializedName("buff_number") val buff_number: Int?,
        @SerializedName("only_enemies") val only_enemies: Boolean?,
        @SerializedName("only_own_troops") val only_own_troops: Boolean?,
        @SerializedName("ignore_buildings") val ignore_buildings: Boolean?,
        @SerializedName("ignore_hero") val ignore_hero: Boolean?,
        @SerializedName("projectile") val projectile: Any?,
        @SerializedName("spawn_character") val spawn_character: Any?,
        @SerializedName("spawn_interval") val spawn_interval: Int?,
        @SerializedName("spawn_randomize_sequence") val spawn_randomize_sequence: Boolean?,
        @SerializedName("spawn_deploy_base_anim") val spawn_deploy_base_anim: Any?,
        @SerializedName("spawn_time") val spawn_time: Int?,
        @SerializedName("spawn_character_level_index") val spawn_character_level_index: Int?,
        @SerializedName("spawn_initial_delay") val spawn_initial_delay: Int?,
        @SerializedName("spawn_max_count") val spawn_max_count: Int?,
        @SerializedName("spawn_max_radius") val spawn_max_radius: Int?,
        @SerializedName("spawn_min_radius") val spawn_min_radius: Int?,
        @SerializedName("spawn_from_min_to_max") val spawn_from_min_to_max: Boolean?,
        @SerializedName("spawn_angle_shift") val spawn_angle_shift: Int?,
        @SerializedName("hits_ground") val hits_ground: Boolean?,
        @SerializedName("hits_air") val hits_air: Boolean?,
        @SerializedName("key") val key: String?,
        @SerializedName("elixir") val elixir: Int?,
        @SerializedName("type") val type: String?,
        @SerializedName("arena") val arena: Int?,
        @SerializedName("description") val description: String?,
        @SerializedName("id") val id: Int?,
        @SerializedName("hitpoints_per_level") val hitpoints_per_level: List<Int>?,
        @SerializedName("damage_per_level") val damage_per_level: List<Int>?,
        @SerializedName("dps_per_level") val dps_per_level: List<Int>?
    )

    data class RawConstantCardsStatsProjectile(
        @SerializedName("name") val name: String?,
        @SerializedName("rarity") val rarity: String?,
        @SerializedName("speed") val speed: Int?,
        @SerializedName("homing") val homing: Boolean?,
        @SerializedName("hit_effect_at_projectile") val hit_effect_at_projectile: Boolean?,
        @SerializedName("damage") val damage: Int?,
        @SerializedName("crown_tower_damage_percent") val crown_tower_damage_percent: Int?,
        @SerializedName("radius") val radius: Int?,
        @SerializedName("aoe_to_air") val aoe_to_air: Boolean?,
        @SerializedName("aoe_to_ground") val aoe_to_ground: Boolean?,
        @SerializedName("only_enemies") val only_enemies: Boolean?,
        @SerializedName("only_own_troops") val only_own_troops: Boolean?,
        @SerializedName("gravity") val gravity: Int?,
        @SerializedName("spawn_const_priority") val spawn_const_priority: Boolean?,
        @SerializedName("use360_frames") val use360_frames: Boolean?,
        @SerializedName("height_from_target_radius") val height_from_target_radius: Boolean?,
        @SerializedName("target_to_edge") val target_to_edge: Boolean?,
        @SerializedName("shakes_targets") val shakes_targets: Boolean?,
        @SerializedName("check_collisions") val check_collisions: Boolean?,
        @SerializedName("damage_per_level") val damage_per_level: List<Int>?,
        @SerializedName("dps") val dps: Int?,
        @SerializedName("dps_per_level") val dps_per_level: List<Int>?
    )
}

fun RawConstantsModel.RawConstant?.isValid(): Boolean {
    if (this == null) {
        return false
    }

    if (this.allianceBadges == null) {
        return false
    }

    if (this.arenas == null) {
        return false
    }

    if (this.cards == null) {
        return false
    }

    if (this.cardsStats == null || this.cardsStats.troops == null) {
        return false
    }

    return true
}

fun RawConstantsModel.RawConstant?.persist(context: Context) {
    val str = this.convertToJson()
    if (str != null && str.isNotEmpty()) {
        val constantsFilename = "royale_constants.json"
        context.openFileOutput(constantsFilename, Context.MODE_PRIVATE).use { stream ->
            stream.write(str.toByteArray())
        }
    }
}

fun RawConstantsModel.RawConstant?.convertToJson(): String? {
    if (this != null) {
        val str = Gson().toJson(this, RawConstantsModel.RawConstant::class.java)
        if (str != null && str.isNotEmpty()) {
            return str
        }
    }

    return null
}