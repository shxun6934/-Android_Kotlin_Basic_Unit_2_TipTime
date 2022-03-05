package com.shunichi.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip() {
        // EditTextに値を入力
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))

        // 20%のRadioButtonをクリック
        onView(withId(R.id.option_twenty_percent)).perform(click())

        // ボタンをクリック
        onView(withId(R.id.calculate_button)).perform(click())

        // 表示されている計算結果に「10」が含まれている
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("10"))))
    }

    @Test
    fun calculate_18_percent_tip() {
        // EditTextに値を入力
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))

        // 18%のRadioButtonをクリック
        onView(withId(R.id.option_eighteen_percent)).perform(click())

        // ボタンをクリック
        onView(withId(R.id.calculate_button)).perform(click())

        // 表示されている計算結果に「9」が含まれている
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("9"))))
    }

    @Test
    fun calculate_15_percent_tip() {
        // EditTextに値を入力
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))

        // 18%のRadioButtonをクリック
        onView(withId(R.id.option_fifteen_percent)).perform(click())

        // ボタンをクリック
        onView(withId(R.id.calculate_button)).perform(click())

        // 表示されている計算結果に「8」が含まれている
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("8"))))
    }

    @Test
    fun round_up_tip() {
        // EditTextに値を入力
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("51.00"))

        // 20%のRadioButtonをクリック
        onView(withId(R.id.option_twenty_percent)).perform(click())

        // ボタンをクリック
        onView(withId(R.id.calculate_button)).perform(click())

        // 表示されている計算結果に「11」が含まれている
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("11"))))

        // Switchをオフにする
        onView(withId(R.id.round_up_switch)).perform(click())

        // ボタンをクリック
        onView(withId(R.id.calculate_button)).perform(click())

        // 表示されている計算結果に「10」が含まれている
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("10"))))
    }
}