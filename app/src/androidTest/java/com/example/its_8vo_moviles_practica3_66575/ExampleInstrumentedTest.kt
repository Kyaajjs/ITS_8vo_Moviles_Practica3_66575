package com.example.its_8vo_moviles_practica3_66575

import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Assert.*

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
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
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNumberButtons() {
        onView(withId(R.id.btn1)).perform(click())
        onView(withId(R.id.txtResult)).check(matches(withText("1")))
    }

    @Test
    fun testAddition() {
        onView(withId(R.id.btn2)).perform(click())
        onView(withId(R.id.btnAdd)).perform(click())
        onView(withId(R.id.btn3)).perform(click())
        onView(withId(R.id.btnEquals)).perform(click())
        onView(withId(R.id.txtResult)).check(matches((withText("5.0"))))
    }

    @Test
    fun testSubtraction() {
        onView(withId(R.id.btn5)).perform(click())
        onView(withId(R.id.btnSubtract)).perform(click())
        onView(withId(R.id.btn2)).perform(click())
        onView(withId(R.id.btnEquals)).perform(click())
        onView(withId(R.id.txtResult)).check(matches(withText("3.0")))
    }

    @Test
    fun testMultiplication() {
        onView(withId(R.id.btn3)).perform(click())
        onView(withId(R.id.btnMultiply)).perform(click())
        onView(withId(R.id.btn4)).perform(click())
        onView(withId(R.id.btnEquals)).perform(click())
        onView(withId(R.id.txtResult)).check(matches(withText("12.0")))
    }

    @Test
    fun testDivision() {
        onView(withId(R.id.btn8)).perform(click())
        onView(withId(R.id.btnDivide)).perform(click())
        onView(withId(R.id.btn2)).perform(click())
        onView(withId(R.id.btnEquals)).perform(click())
        onView(withId(R.id.txtResult)).check(matches(withText("4.0")))
    }
}
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
