package ru.otus.project.gateway.controller.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.project.gateway.config.Timetable;
import ru.otus.project.gateway.controller.ModelBuilder;

@Controller
@RequiredArgsConstructor
public class RoomController {
    private final Timetable timetable;
    private final ModelBuilder builder;

    @GetMapping("/room/{id}/timetable")
    public String roomTimetable(Model model, @PathVariable String id) {
        builder.build(
            model
                .addAttribute("roomId", id)
                .addAttribute("timetableStart", timetable.getStartHour())
                .addAttribute("timetableEnd", timetable.getEndHour())
                .addAttribute("timetablePeriod", timetable.getPeriodInDays())
        );

        return "timetable";
    }

    @GetMapping("/rooms/view")
    public String rooms() {
        return "rooms";
    }
}
