package com.adevinta.android.barista.internal.matcher

import android.view.View
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class BooleanMatcher<T : View>(
    private val message: String? = null,
    private val block: (T) -> Boolean
) : TypeSafeMatcher<T>() {
  override fun describeTo(description: Description) {
    message?.let {
      description.appendText(message)
    } ?: description.appendText("custom condition [use `assertionDescription` parameter on `assertAny` to setup descriptive message]")
  }

  override fun matchesSafely(item: T): Boolean = (item as? T)?.let(block) ?: false
}