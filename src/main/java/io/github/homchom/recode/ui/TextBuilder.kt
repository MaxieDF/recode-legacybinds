package io.github.homchom.recode.ui

import io.github.homchom.recode.render.ColorPalette
import io.github.homchom.recode.render.IntegralColor
import net.minecraft.network.chat.ClickEvent
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.HoverEvent
import net.minecraft.network.chat.HoverEvent.EntityTooltipInfo
import net.minecraft.network.chat.HoverEvent.ItemStackInfo
import net.minecraft.network.chat.Style
import net.minecraft.resources.ResourceLocation

typealias TextScope = TextBuilder.() -> Unit

inline fun text(style: Style = Style.EMPTY, builder: TextScope) =
    TextBuilder(style).apply(builder).builtText

fun translateText(key: String, vararg args: Any): Component = Component.translatable(key, *args)
fun literalText(string: String): Component = Component.literal(string)

@Suppress("unused")
class TextBuilder(style: Style = Style.EMPTY) {
    val builtText: Component get() = _text
    private val _text = Component.empty().withStyle(style)

    inline val black get() = ColorPalette.BLACK
    inline val darkBlue get() = ColorPalette.DARK_BLUE
    inline val darkGreen get() = ColorPalette.DARK_GREEN
    inline val darkAqua get() = ColorPalette.DARK_AQUA
    inline val darkRed get() = ColorPalette.DARK_RED
    inline val darkPurple get() = ColorPalette.DARK_PURPLE
    inline val gold get() = ColorPalette.GOLD
    inline val gray get() = ColorPalette.GRAY
    inline val darkGray get() = ColorPalette.DARK_GRAY
    inline val blue get() = ColorPalette.BLUE
    inline val green get() = ColorPalette.GREEN
    inline val aqua get() = ColorPalette.AQUA
    inline val red get() = ColorPalette.RED
    inline val lightPurple get() = ColorPalette.LIGHT_PURPLE
    inline val yellow get() = ColorPalette.YELLOW
    inline val white get() = ColorPalette.WHITE

    val openUrl get() = ClickEvent.Action.OPEN_URL
    val openFile get() = ClickEvent.Action.OPEN_FILE
    val runCommand get() = ClickEvent.Action.RUN_COMMAND
    val suggestCommand get() = ClickEvent.Action.SUGGEST_COMMAND
    val changePage get() = ClickEvent.Action.CHANGE_PAGE
    val copyToClipboard get() = ClickEvent.Action.COPY_TO_CLIPBOARD

    val showText: HoverEvent.Action<Component> get() = HoverEvent.Action.SHOW_TEXT
    val showItem: HoverEvent.Action<ItemStackInfo> get() = HoverEvent.Action.SHOW_ITEM
    val showEntity: HoverEvent.Action<EntityTooltipInfo> get() = HoverEvent.Action.SHOW_ENTITY

    fun append(component: Component) {
        _text += component
    }

    inline fun appendBlock(style: Style, scope: TextScope) = append(text(style, scope))

    fun translate(key: String, vararg args: Any) = append(translateText(key, *args))
    fun literal(string: String) = append(literalText(string))
    fun keybind(key: String) = append(Component.keybind(key))

    fun space() = literal(" ")

    inline fun color(color: IntegralColor, scope: TextScope) =
        appendBlock(Style.EMPTY.withColor(color.toInt()), scope)

    inline fun color(hex: Int, scope: TextScope) =
        appendBlock(Style.EMPTY.withColor(hex), scope)

    inline fun bold(scope: TextScope) =
        appendBlock(Style.EMPTY.withBold(true), scope)

    inline fun underline(scope: TextScope) =
        appendBlock(Style.EMPTY.withUnderlined(true), scope)

    inline fun italic(scope: TextScope) =
        appendBlock(Style.EMPTY.withItalic(true), scope)

    inline fun strikethrough(scope: TextScope) =
        appendBlock(Style.EMPTY.withStrikethrough(true), scope)

    inline fun obfuscated(scope: TextScope) =
        appendBlock(Style.EMPTY.withObfuscated(true), scope)

    inline fun onClick(action: ClickEvent.Action, value: String, scope: TextScope) =
        appendBlock(Style.EMPTY.withClickEvent(ClickEvent(action, value)), scope)

    inline fun <T> onHover(action: HoverEvent.Action<T>, value: T & Any, scope: TextScope) =
        appendBlock(Style.EMPTY.withHoverEvent(HoverEvent(action, value)), scope)

    inline fun insert(string: String, scope: TextScope) =
        appendBlock(Style.EMPTY.withInsertion(string), scope)

    inline fun font(id: ResourceLocation, scope: TextScope) =
        appendBlock(Style.EMPTY.withFont(id), scope)
}