package com.nighthawk.spring_portfolio.mvc.quotes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String quote;




    
    public static String[] init() {
        final String[] quotesArray = {
            "Every day is a gift, and even in the toughest times, there are still reasons to smile.",
            "You are stronger than you think, and braver than you know. Keep fighting.",
            "'Never, never, never give up.' - Winston Churchill",
            "'The human spirit is stronger than anything that can happen to it.' - C.C. Scott",
            "You were given this life because you are strong enough to live it.",
            "Strength doesn't come from what you can do; it comes from overcoming the things you once thought you couldn't.",
            "You are not alone on this journey. We are here to support and love you every step of the way.",
            "You are an inspiration to everyone who knows you. Your strength is a beacon of hope.",
            "Hope is the only thing stronger than fear.",
            "Your journey is tough, but it's making you a warrior. Keep going.",
            "'In the middle of every difficulty lies opportunity.' - Albert Einstein",
            "You have a 100% track record of getting through difficult days. You're doing great.",
            "Life is a collection of moments. Make each one beautiful, no matter the circumstances.",
            "Every accomplishment starts with the decision to try.",
            "The strongest people are not those who show strength in front of us but those who win battles we know nothing about.",
            "The best view comes after the hardest climb.",
            "No matter how much it hurts now, someday you will look back and realize your struggles changed your life for the better.",
            "Every day is a new beginning. Take a deep breath, smile, and start again.",
            "'You are the master of your fate; you are the captain of your soul.' - Invictus",
            "The sun is a daily reminder that we too can rise again from the darkness, that we too can shine our own light."
        };
        return quotesArray;
    }
}
