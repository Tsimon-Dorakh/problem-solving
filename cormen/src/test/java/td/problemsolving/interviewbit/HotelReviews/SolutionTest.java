package td.problemsolving.interviewbit.HotelReviews;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        ArrayList<String> xs;
        ArrayList<Integer> expected;
        String s;

        s = "wkgejuydh_tamszgvvvr_s_gej_mszgvvvr_z_juydh_zgvvvr";
        xs = new ArrayList<>(ImmutableList.of("ui_wa_a_yaka_opuh_rur_ka_uh_r", "z_rufcts"));
        expected = new ArrayList<>(ImmutableList.of(1, 0));
        assertEquals(expected, new Solution().solve(s, xs));

        s = "rof_yv";
        xs = new ArrayList<>(ImmutableList.of("uw_m_ojcu_gu_tmb_cu_fv_b_nw", "prj_tt_pv_j_r"));
        expected = new ArrayList<>(ImmutableList.of(0, 1));
        assertEquals(expected, new Solution().solve(s, xs));

        s = "cool_ice_wifi";
        xs = new ArrayList<>(ImmutableList.of("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));
        expected = new ArrayList<>(ImmutableList.of(2, 0, 1));
        assertEquals(expected, new Solution().solve(s, xs));
    }
}
