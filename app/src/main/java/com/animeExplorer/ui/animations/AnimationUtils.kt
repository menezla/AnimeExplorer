package com.animeExplorer.ui.animations

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

/**
 * Animation utilities for the anime explorer app.
 * Provides smooth transitions and engaging animations.
 * 
 * @author udit
 */

/**
 * Fade in animation for content appearing.
 * 
 * @param visible Whether the content should be visible
 * @param content The content to animate
 * @author udit
 */
@Composable
fun FadeInAnimation(
    visible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(
            animationSpec = tween(
                durationMillis = 300,
                easing = FastOutSlowInEasing
            )
        ) + expandVertically(
            animationSpec = tween(300),
            expandFrom = Alignment.Top
        ),
        exit = fadeOut(
            animationSpec = tween(
                durationMillis = 200,
                easing = FastOutLinearInEasing
            )
        ) + shrinkVertically(
            animationSpec = tween(200),
            shrinkTowards = Alignment.Top
        ),
        content = content
    )
}

/**
 * Slide in animation for content from the bottom.
 * 
 * @param visible Whether the content should be visible
 * @param content The content to animate
 * @author udit
 */
@Composable
fun SlideInAnimation(
    visible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = tween(400, easing = FastOutSlowInEasing),
            initialOffsetY = { it }
        ) + fadeIn(
            animationSpec = tween(400)
        ),
        exit = slideOutVertically(
            animationSpec = tween(300, easing = FastOutLinearInEasing),
            targetOffsetY = { it }
        ) + fadeOut(
            animationSpec = tween(300)
        ),
        content = content
    )
}

/**
 * Scale animation for interactive elements.
 * 
 * @param visible Whether the content should be visible
 * @param content The content to animate
 * @author udit
 */
@Composable
fun ScaleAnimation(
    visible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(
            animationSpec = tween(300, easing = FastOutSlowInEasing),
            initialScale = 0.8f
        ) + fadeIn(
            animationSpec = tween(300)
        ),
        exit = scaleOut(
            animationSpec = tween(200, easing = FastOutLinearInEasing),
            targetScale = 0.8f
        ) + fadeOut(
            animationSpec = tween(200)
        ),
        content = content
    )
}

/**
 * Pulse animation for loading states.
 * 
 * @param content The content to animate
 * @author udit
 */
@Composable
fun PulseAnimation(
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
    ) {
        content()
    }
}

/**
 * Bounce animation for success states.
 * 
 * @param visible Whether the content should be visible
 * @param content The content to animate
 * @author udit
 */
@Composable
fun BounceAnimation(
    visible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
            initialScale = 0.3f
        ) + fadeIn(
            animationSpec = tween(300)
        ),
        exit = scaleOut(
            animationSpec = tween(200),
            targetScale = 0.3f
        ) + fadeOut(
            animationSpec = tween(200)
        ),
        content = content
    )
}
