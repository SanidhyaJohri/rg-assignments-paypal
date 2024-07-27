const txnService = require('../services');

async function getTransactions(req, res) {
    const txns = await txnService.getTransactions();
    return res.json(txns);
}

async function getSingleTransaction(req, res) {
    const { id } = req.params;
    const txn = await txnService.getTransactions(id);
    if (!txn) {
        return res.status(404).json({ message: 'Transaction not found' });
    }
    return res.json(txn);
}

async function createTransaction(req, res) {
    const details = req.body;
    const newId = await txnService.createTransaction(details);
    return res.status(201).json(newId);
}


module.exports = { getTransactions, getSingleTransaction, createTransaction };