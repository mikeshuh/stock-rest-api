// src/pages/HelpPage.tsx
import React from 'react';

const HelpPage: React.FC = () => {
  const faqs = [
    {
      question: "How do I buy stocks?",
      answer: "To buy stocks, navigate to the stock's page and click the 'Buy' button. Enter the quantity you want to purchase and confirm the transaction."
    },
    {
      question: "How do I sell stocks?",
      answer: "To sell stocks, go to your portfolio page, find the stock you want to sell, and click the 'Sell' button. Enter the quantity you want to sell and confirm the transaction."
    },
    {
      question: "What is a watchlist?",
      answer: "A watchlist is a list of stocks you're interested in but haven't purchased yet. You can add stocks to your watchlist to easily track their performance."
    },
    // Add more FAQs as needed
  ];

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Help & FAQ</h1>
      <div className="bg-white p-6 rounded-lg shadow">
        <h2 className="text-2xl font-semibold mb-4">Frequently Asked Questions</h2>
        {faqs.map((faq, index) => (
          <div key={index} className="mb-4">
            <h3 className="text-lg font-semibold mb-2">{faq.question}</h3>
            <p className="text-gray-600">{faq.answer}</p>
          </div>
        ))}
      </div>
      <div className="mt-6 bg-white p-6 rounded-lg shadow">
        <h2 className="text-2xl font-semibold mb-4">Contact Support</h2>
        <form>
          <div className="mb-4">
            <label htmlFor="name" className="block mb-2">Name</label>
            <input type="text" id="name" className="w-full p-2 border rounded" />
          </div>
          <div className="mb-4">
            <label htmlFor="email" className="block mb-2">Email</label>
            <input type="email" id="email" className="w-full p-2 border rounded" />
          </div>
          <div className="mb-4">
            <label htmlFor="message" className="block mb-2">Message</label>
            <textarea id="message" rows={4} className="w-full p-2 border rounded"></textarea>
          </div>
          <button type="submit" className="bg-blue-500 text-white p-2 rounded hover:bg-blue-600">
            Send Message
          </button>
        </form>
      </div>
    </div>
  );
};

export default HelpPage;